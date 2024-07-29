package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    private Stage primaryStage;
    private Scene firstView, secondView, thirdView;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;

        BorderPane borderPane = new BorderPane();
        Label firstLabel = new Label("First view!");
        Button toSecondViewButton = new Button("To the second view!");
        toSecondViewButton.setOnAction(e -> primaryStage.setScene(secondView));
        borderPane.setTop(firstLabel);
        borderPane.setCenter(toSecondViewButton);
        firstView = new Scene(borderPane, 300, 200);

        VBox vBox = new VBox();
        Button toThirdViewButton = new Button("To the third view!");
        toThirdViewButton.setOnAction(e -> primaryStage.setScene(thirdView));
        Label secondLabel = new Label("Second view!");
        vBox.getChildren().addAll(toThirdViewButton, secondLabel);
        secondView = new Scene(vBox, 300, 200);

        GridPane gridPane = new GridPane();
        Label thirdLabel = new Label("Third view!");
        Button toFirstViewButton = new Button("To the first view!");
        toFirstViewButton.setOnAction(e -> primaryStage.setScene(firstView));
        gridPane.add(thirdLabel, 0, 0);
        gridPane.add(toFirstViewButton, 1, 1);
        thirdView = new Scene(gridPane, 300, 200);

        primaryStage.setScene(firstView);
        primaryStage.setTitle("Multiple Views");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
