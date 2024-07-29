package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("University of Helsinki Rankings");

        final NumberAxis xAxis = new NumberAxis(2007, 2017, 1);
        final NumberAxis yAxis = new NumberAxis(50, 80, 5);
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Ranking of University of Helsinki");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Ranking");

        series.getData().add(new XYChart.Data<>(2007, 73));
        series.getData().add(new XYChart.Data<>(2008, 68));
        series.getData().add(new XYChart.Data<>(2009, 72));
        series.getData().add(new XYChart.Data<>(2010, 72));
        series.getData().add(new XYChart.Data<>(2011, 74));
        series.getData().add(new XYChart.Data<>(2012, 73));
        series.getData().add(new XYChart.Data<>(2013, 76));
        series.getData().add(new XYChart.Data<>(2014, 73));
        series.getData().add(new XYChart.Data<>(2015, 67));
        series.getData().add(new XYChart.Data<>(2016, 56));
        series.getData().add(new XYChart.Data<>(2017, 56));

        lineChart.getData().add(series);

        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
