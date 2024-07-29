package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private boolean xTurn = true;
    private boolean gameEnded = false;
    private Button[][] buttons = new Button[3][3];
    private Label statusLabel = new Label("Turn: X");

    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(statusLabel);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button(" ");
                button.setFont(javafx.scene.text.Font.font("Monospaced", 40));
                button.setPrefSize(100, 100);
                button.setOnAction(e -> handleButtonClick(button));
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }

        borderPane.setCenter(gridPane);

        Scene scene = new Scene(borderPane, 350, 350);
        stage.setScene(scene);
        stage.setTitle("Tic-Tac-Toe");
        stage.show();
    }

    private void handleButtonClick(Button button) {
        if (gameEnded || !button.getText().equals(" ")) {
            return;
        }

        if (xTurn) {
            button.setText("X");
            statusLabel.setText("Turn: O");
        } else {
            button.setText("O");
            statusLabel.setText("Turn: X");
        }

        xTurn = !xTurn;

        if (checkForWin()) {
            statusLabel.setText("The end!");
            gameEnded = true;
        } else if (isBoardFull()) {
            statusLabel.setText("It's a draw!");
            gameEnded = true;
        }
    }

    private boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][0].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().equals(" ")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[0][i].getText().equals(buttons[2][i].getText()) &&
                !buttons[0][i].getText().equals(" ")) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[0][0].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().equals(" ")) {
            return true;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[0][2].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().equals(" ")) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
