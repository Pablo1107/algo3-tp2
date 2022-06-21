package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        FileInputStream imageFile = null;
        try {
            imageFile = new FileInputStream("src/main/java/edu/fiuba/algo3/vista/recursos/jugador.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(imageFile);
        ImageView imageView = new ImageView(image);

        Parent root = new Group(imageView);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    imageView.setX(imageView.getX() + 10);
                    break;
                case LEFT:
                    imageView.setX(imageView.getX() - 10);
                    break;
                case UP:
                    imageView.setY(imageView.getY() - 10);
                    break;
                case DOWN:
                    imageView.setY(imageView.getY() + 10);
                    break;
                default:
                    break;
            }
            System.out.printf("Posicion: (%s,%s)\n", imageView.getX(), imageView.getY());
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
