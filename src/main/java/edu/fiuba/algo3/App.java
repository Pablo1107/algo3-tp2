package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorCambioPantallas;
import edu.fiuba.algo3.vista.VistaPantallaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static final String ARCHIVO_ESTILOS = "estilos.css";

    @Override
    public void start(Stage stage) {
        ControladorCambioPantallas controladorCambioPantallas = new ControladorCambioPantallas(stage);
        VistaPantallaInicio pantallaInicio = new VistaPantallaInicio(controladorCambioPantallas);

        Scene scene = new Scene(pantallaInicio);
        App.aplicarEstilos(scene);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void aplicarEstilos(Scene scene) {
        String archivoEstilos = App.class.getResource(ARCHIVO_ESTILOS).toExternalForm();
        scene.getStylesheets().add(archivoEstilos);
    }
}
