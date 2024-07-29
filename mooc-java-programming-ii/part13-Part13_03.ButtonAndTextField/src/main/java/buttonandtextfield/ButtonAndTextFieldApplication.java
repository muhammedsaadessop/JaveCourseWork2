package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {

    @Override
    public void start(Stage stage) {
        Button button = new Button("Click Me");
        TextField textField = new TextField();

        VBox vbox = new VBox(button, textField);

        Scene scene = new Scene(vbox);

        stage.setScene(scene);
        stage.setTitle("Button and TextField");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
