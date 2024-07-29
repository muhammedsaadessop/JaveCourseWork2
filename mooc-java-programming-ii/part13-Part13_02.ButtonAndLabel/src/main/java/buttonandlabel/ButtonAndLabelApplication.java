package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage stage) {
        Button button = new Button("Click Me");
        Label label = new Label("This is a Label");

        VBox vbox = new VBox(label, button);

        Scene scene = new Scene(vbox);

        stage.setScene(scene);
        stage.setTitle("Button and Label");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
