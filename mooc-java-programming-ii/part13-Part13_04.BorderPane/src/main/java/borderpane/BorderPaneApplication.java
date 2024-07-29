package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    @Override
    public void start(Stage stage) {
        Label northLabel = new Label("NORTH");
        Label eastLabel = new Label("EAST");
        Label southLabel = new Label("SOUTH");

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(northLabel);
        borderPane.setRight(eastLabel);
        borderPane.setBottom(southLabel);

        Scene scene = new Scene(borderPane, 300, 200);

        stage.setScene(scene);
        stage.setTitle("BorderPane Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
