package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static final String ARCHIVO_ESTILOS = "app.css";

    @Override
    public void start(Stage stage) {
        VistaInicio vistaInicio = new VistaInicio(stage);
        Scene scene = new Scene(vistaInicio.getNodoRaiz());
        this.cargarEstilos(scene);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void cargarEstilos(Scene scene) {
        String archivoEstilos = this.getClass().getResource(ARCHIVO_ESTILOS).toExternalForm();
        scene.getStylesheets().add(archivoEstilos);
    }
}
