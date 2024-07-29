package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage stage) {
        TextArea textArea = new TextArea();

        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is:");

        HBox bottomPane = new HBox(10); 
        bottomPane.getChildren().addAll(lettersLabel, wordsLabel, longestWordLabel);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(textArea);
        borderPane.setBottom(bottomPane);

        Scene scene = new Scene(borderPane, 600, 400);

        stage.setScene(scene);
        stage.setTitle("Text Statistics");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
