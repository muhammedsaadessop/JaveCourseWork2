package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 1);
        xAxis.setLabel("Year");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative Support of Finnish Parties");

        try (BufferedReader br = new BufferedReader(new FileReader("partiesdata.tsv"))) {
            String line;
            Set<String> addedParties = new HashSet<>();
            while ((line = br.readLine()) != null) {
                String[] pieces = line.split("\t");
                if (pieces.length < 2) continue;

                String party = pieces[0];
                if (addedParties.contains(party)) continue; // Skip if the party has already been added

                addedParties.add(party);
                XYChart.Series<Number, Number> series = new XYChart.Series<>();
                series.setName(party);

                for (int i = 1; i < pieces.length; i++) {
                    double support = pieces[i].equals("-") ? 0 : Double.parseDouble(pieces[i]);
                    series.getData().add(new XYChart.Data<>(1968 + i - 1, support));
                }

                lineChart.getData().add(series);
            }

            if (lineChart.getData().size() != 7) {
                throw new RuntimeException("The number of lines in the chart is incorrect. Expected 7 lines.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Parties Support Over Time");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
