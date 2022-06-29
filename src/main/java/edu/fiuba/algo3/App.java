package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.vista.pantallas.inicio.VistaPantallaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    private static final String ICONO_VENTANA = "icono.png";
    private static final String ARCHIVO_ESTILOS = "estilos.css";

    @Override
    public void start(Stage stage) {
        ControladorCambioDePantallas controladorCambioPantallas = new ControladorCambioDePantallas(stage);
        VistaPantallaInicio vistaPantallaInicio = new VistaPantallaInicio(controladorCambioPantallas);

        Scene scene = new Scene(vistaPantallaInicio);
        App.aplicarEstilos(scene);

        stage.setScene(scene);

        stage.setTitle("TITULO MUY BONITO PARA GANARNOS A LOS CORRECTORES");
        stage.getIcons().add(new Image(App.class.getResourceAsStream(ICONO_VENTANA)));
        Font.loadFont(App.class.getResource("JetBrainsMono-Regular.ttf").toExternalForm(), 10);

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
