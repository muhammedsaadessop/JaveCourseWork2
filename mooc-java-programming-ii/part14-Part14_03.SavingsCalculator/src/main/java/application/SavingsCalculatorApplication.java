package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        xAxis.setLabel("Year");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Savings (€)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Over Time");

        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setMajorTickUnit(50);
        savingsSlider.setBlockIncrement(10);

        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickLabels(true);
        interestSlider.setShowTickMarks(true);
        interestSlider.setMajorTickUnit(2);
        interestSlider.setBlockIncrement(0.5);

        Label savingsLabel = new Label("Monthly savings: €" + (int) savingsSlider.getValue());
        Label interestLabel = new Label("Yearly interest rate: " + (int) interestSlider.getValue() + "%");

        BorderPane savingsPane = new BorderPane();
        savingsPane.setLeft(new Label("Monthly savings"));
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(savingsLabel);

        BorderPane interestPane = new BorderPane();
        interestPane.setLeft(new Label("Yearly interest rate"));
        interestPane.setCenter(interestSlider);
        interestPane.setRight(interestLabel);

        VBox vBox = new VBox(savingsPane, interestPane);

        BorderPane root = new BorderPane();
        root.setTop(vBox);
        root.setCenter(lineChart);

        savingsSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            savingsLabel.setText("Monthly savings: €" + newVal.intValue());
            updateChart(lineChart, newVal.doubleValue(), interestSlider.getValue());
        });

        interestSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            interestLabel.setText("Yearly interest rate: " + newVal.intValue() + "%");
            updateChart(lineChart, savingsSlider.getValue(), newVal.doubleValue());
        });

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Savings Calculator");
        stage.show();
    }

    private void updateChart(LineChart<Number, Number> lineChart, double monthlySavings, double interestRate) {
        XYChart.Series<Number, Number> savingsSeries = new XYChart.Series<>();
        savingsSeries.setName("Monthly Savings");

        XYChart.Series<Number, Number> compoundSeries = new XYChart.Series<>();
        compoundSeries.setName("With Interest");

        double totalSavings = 0;
        double totalCompound = 0;

        for (int year = 0; year <= 30; year++) {
            totalSavings += monthlySavings * 12;
            totalCompound = totalCompound * (1 + interestRate / 100) + monthlySavings * 12;

            savingsSeries.getData().add(new XYChart.Data<>(year, totalSavings));
            compoundSeries.getData().add(new XYChart.Data<>(year, totalCompound));
        }

        lineChart.getData().clear();
        lineChart.getData().addAll(savingsSeries, compoundSeries);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
