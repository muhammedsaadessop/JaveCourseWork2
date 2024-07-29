package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class UnfairAdvertisementApplication extends Application {

    @Override
    public void start(Stage window) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis(70.0, 80.0, 1.0);
        yAxis.setLabel("Speed (Mbps)");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Internet Speed Comparison");
        barChart.setLegendVisible(true);

        XYChart.Series<String, Number> speeds = new XYChart.Series<>();
        speeds.setName("Internet Speeds");
        speeds.getData().add(new XYChart.Data<>("NDA", 77.4));
        speeds.getData().add(new XYChart.Data<>("Fastie", 77.2));
        speeds.getData().add(new XYChart.Data<>("SuperNet", 76.9));
        speeds.getData().add(new XYChart.Data<>("Meganet", 76.5));

        barChart.getData().add(speeds);
        Scene view = new Scene(barChart, 600, 400);
        window.setScene(view);
        window.setTitle("Internet Speed Comparison");
        window.show();
    }

    public static void main(String[] args) {
        launch(UnfairAdvertisementApplication.class);
    }
}
