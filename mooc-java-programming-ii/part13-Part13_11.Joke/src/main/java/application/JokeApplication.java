package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage stage) {
        Label displayLabel = new Label("What do you call a bear with no teeth?");
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        jokeButton.setOnAction(e -> displayLabel.setText("What do you call a bear with no teeth?"));
        answerButton.setOnAction(e -> displayLabel.setText("A gummy bear."));
        explanationButton.setOnAction(e -> displayLabel.setText("A gummy bear is a type of candy, and 'gummy' also refers to having no teeth."));

        VBox layout = new VBox(10, displayLabel, jokeButton, answerButton, explanationButton);
        Scene scene = new Scene(layout, 400, 300);

        stage.setScene(scene);
        stage.setTitle("Joke Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
