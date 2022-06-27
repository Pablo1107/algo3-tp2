package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        VistaInicio vistaInicio = new VistaInicio();

        Scene scene = new Scene(vistaInicio.asParent());
        // TODO: Cambiar esto, odio como Java maneja los recursos.
        String archivoEstilos = this.getClass().getResource("app.css").toExternalForm();
        scene.getStylesheets().add(archivoEstilos);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
