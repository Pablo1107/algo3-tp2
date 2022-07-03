package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    public static final String TITULO_JUEGO = "La Messineta";
    public static final String FUENTE_TITULO = "titulo.ttf";
    private static final String ICONO_JUEGO = "icono.png";
    private static final String ARCHIVO_ESTILOS = "estilos.css";

    @Override
    public void start(Stage stage) {
        ControladorCambioDePantallas controladorCambioPantallas = new ControladorCambioDePantallas(stage);
        controladorCambioPantallas.cargarPantallaInicio();

        stage.setTitle(TITULO_JUEGO);
        stage.getIcons().add(new Image(App.class.getResourceAsStream(ICONO_JUEGO)));

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
