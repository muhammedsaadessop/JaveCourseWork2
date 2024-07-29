package myFirstApplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyFirstApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My first application");
        primaryStage.setScene(new Scene(new Label("Hello World!"), 200, 100));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
