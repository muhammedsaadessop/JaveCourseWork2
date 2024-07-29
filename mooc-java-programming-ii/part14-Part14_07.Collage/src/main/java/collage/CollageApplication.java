package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {
        Image sourceImage = new Image("file:monalisa.png");
        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();
        int smallWidth = width / 2;
        int smallHeight = height / 2;

        WritableImage smallImage = new WritableImage(smallWidth, smallHeight);
        PixelReader imageReader = sourceImage.getPixelReader();
        PixelWriter smallImageWriter = smallImage.getPixelWriter();

        for (int y = 0; y < smallHeight; y++) {
            for (int x = 0; x < smallWidth; x++) {
                Color color = imageReader.getColor(x * 2, y * 2);
                smallImageWriter.setColor(x, y, color);
            }
        }

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter targetImageWriter = targetImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color;
                if (x < smallWidth && y < smallHeight) {
                    color = smallImage.getPixelReader().getColor(x, y);
                } else if (x < width / 2 && y < height / 2) {
                    color = smallImage.getPixelReader().getColor(x, y);
                } else if (x >= width / 2 && y < height / 2) {
                    color = smallImage.getPixelReader().getColor(x - smallWidth, y);
                } else if (x < width / 2 && y >= height / 2) {
                    color = smallImage.getPixelReader().getColor(x, y - smallHeight);
                } else {
                    color = smallImage.getPixelReader().getColor(x - smallWidth, y - smallHeight);
                }

                Color negativeColor = new Color(1.0 - color.getRed(), 1.0 - color.getGreen(), 1.0 - color.getBlue(), color.getOpacity());
                targetImageWriter.setColor(x, y, negativeColor);
            }
        }

        ImageView imageView = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(imageView);

        stage.setScene(new Scene(pane, width, height));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
