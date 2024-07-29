package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage stage) {
        TextField textField = new TextField();
        Button button = new Button("Copy");
        Label label = new Label();

        button.setOnAction(event -> {
            String text = textField.getText();
            label.setText(text);
        });

        VBox vbox = new VBox(10);  
        vbox.getChildren().addAll(textField, button, label);

        Scene scene = new Scene(vbox, 300, 200);

        stage.setScene(scene);
        stage.setTitle("Notifier");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
