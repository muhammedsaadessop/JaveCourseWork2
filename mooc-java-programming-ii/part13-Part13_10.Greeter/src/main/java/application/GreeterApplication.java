package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    private Stage primaryStage;
    private Scene firstScene, secondScene;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;

        TextField nameField = new TextField();
        Button submitButton = new Button("Submit");
        VBox firstLayout = new VBox(nameField, submitButton);
        firstScene = new Scene(firstLayout, 300, 200);

        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            Label greetingLabel = new Label("Welcome " + name + "!");
            VBox secondLayout = new VBox(greetingLabel);
            secondScene = new Scene(secondLayout, 300, 200);
            primaryStage.setScene(secondScene);
        });

        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Greeter Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
