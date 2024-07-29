package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Canvas canvas = new Canvas(400, 400);
        borderPane.setCenter(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawSmiley(gc);

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Smiley Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawSmiley(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 400, 400);

        gc.setFill(Color.BLACK);

        gc.fillOval(100, 100, 200, 200); 

        gc.setFill(Color.WHITE);
        gc.fillOval(150, 150, 30, 30); 
        gc.fillOval(220, 150, 30, 30); 

        gc.setFill(Color.BLACK);
        gc.fillOval(155, 155, 15, 15); 
        gc.fillOval(225, 155, 15, 15); 

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);
        gc.strokeArc(140, 180, 120, 80, 0, -180, javafx.scene.shape.ArcType.OPEN); // Smile
    }

    public static void main(String[] args) {
        launch(args);
    }
}
