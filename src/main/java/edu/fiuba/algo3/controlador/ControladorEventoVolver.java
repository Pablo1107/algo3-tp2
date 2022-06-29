package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorEventoVolver implements EventHandler<ActionEvent> {
    private static final String ARCHIVO_ESTILOS = "app.css";
    private Stage stage;

    public ControladorEventoVolver(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaInicio root = new VistaInicio(this.stage);
        Scene scene = new Scene(root.getNodoRaiz(), 1250, 750);
        this.cargarEstilos(scene);
        stage.setScene(scene);
    }

    private void cargarEstilos(Scene scene) {
        String archivoEstilos = App.class.getResource(ARCHIVO_ESTILOS).toExternalForm();
        // TODO: Descubrir como mejorar la parte esta.
        scene.getStylesheets().add(archivoEstilos);
    }
}
