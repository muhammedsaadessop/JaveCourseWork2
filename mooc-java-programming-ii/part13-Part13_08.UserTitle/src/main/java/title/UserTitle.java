package title;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UserTitle extends Application {

    @Override
    public void start(Stage stage) {
        String title = getParameters().getRaw().get(0);
        stage.setTitle(title);

        Label label = new Label("This is a GUI with the title: " + title);
        BorderPane borderPane = new BorderPane(label);

        Scene scene = new Scene(borderPane, 400, 300);

        stage.setScene(scene);
        stage.show();
    }
}
