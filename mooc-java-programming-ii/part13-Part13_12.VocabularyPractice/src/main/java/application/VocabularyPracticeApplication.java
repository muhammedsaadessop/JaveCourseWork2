package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class VocabularyPracticeApplication extends Application {

    private Map<String, String> wordPairs = new HashMap<>();
    private Random random = new Random();
    private Label feedbackLabel = new Label();

    @Override
    public void start(Stage stage) {
        Button enterWordsButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        enterWordsButton.setOnAction(e -> showInputView(stage));
        practiceButton.setOnAction(e -> showPracticeView(stage));

        VBox mainLayout = new VBox(10, enterWordsButton, practiceButton);
        Scene mainScene = new Scene(mainLayout, 300, 200);

        stage.setScene(mainScene);
        stage.setTitle("Vocabulary Practice");
        stage.show();
    }

    private void showInputView(Stage stage) {
        TextField wordField = new TextField();
        wordField.setPromptText("Word");
        TextField translationField = new TextField();
        translationField.setPromptText("Translation");

        Button addButton = new Button("Add the word pair");
        addButton.setOnAction(e -> {
            String word = wordField.getText();
            String translation = translationField.getText();
            if (!word.isEmpty() && !translation.isEmpty()) {
                wordPairs.put(word, translation);
                wordField.clear();
                translationField.clear();
            }
        });

        VBox inputLayout = new VBox(10, wordField, translationField, addButton, feedbackLabel);
        Scene inputScene = new Scene(inputLayout, 300, 200);

        stage.setScene(inputScene);
    }

    private void showPracticeView(Stage stage) {
        TextField translationField = new TextField();
        translationField.setPromptText("Translation");

        Button checkButton = new Button("Check");
        checkButton.setOnAction(e -> {
            if (!wordPairs.isEmpty()) {
                List<String> words = new ArrayList<>(wordPairs.keySet());
                String word = words.get(random.nextInt(words.size()));
                String correctTranslation = wordPairs.get(word);
                String userTranslation = translationField.getText();

                if (userTranslation.equals(correctTranslation)) {
                    feedbackLabel.setText("Correct!");
                } else {
                    feedbackLabel.setText("Incorrect! The correct translation is: " + correctTranslation);
                }
            } else {
                feedbackLabel.setText("No words to practice.");
            }
            translationField.clear();
        });

        VBox practiceLayout = new VBox(10, new Label("Translate this word:"), translationField, checkButton, feedbackLabel);
        Scene practiceScene = new Scene(practiceLayout, 300, 200);

        stage.setScene(practiceScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
