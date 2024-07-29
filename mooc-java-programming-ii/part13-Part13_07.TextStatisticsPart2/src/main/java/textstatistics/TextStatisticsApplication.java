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

        HBox statsBox = new HBox(10);
        statsBox.getChildren().addAll(lettersLabel, wordsLabel, longestWordLabel);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(textArea);
        borderPane.setBottom(statsBox);

        textArea.textProperty().addListener((obs, oldText, newText) -> {
            String text = newText.trim();
            int letterCount = 0;
            int wordCount = 0;
            String longestWord = "";

            if (!text.isEmpty()) {
                String[] words = text.split("\\s+");
                wordCount = words.length;
                for (String word : words) {
                    String cleanWord = word.replaceAll("[^a-zA-Z]", "");
                    letterCount += cleanWord.length();
                    if (cleanWord.length() > longestWord.length()) {
                        longestWord = cleanWord;
                    }
                }
            }

            lettersLabel.setText("Letters: " + letterCount);
            wordsLabel.setText("Words: " + wordCount);
            longestWordLabel.setText("The longest word is: " + longestWord);
        });

        Scene scene = new Scene(borderPane, 400, 300);

        stage.setScene(scene);
        stage.setTitle("Text Statistics");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
