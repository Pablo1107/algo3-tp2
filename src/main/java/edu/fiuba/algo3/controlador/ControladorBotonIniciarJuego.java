package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.juego.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonIniciarJuego implements EventHandler<ActionEvent> {
    private static final String ARCHIVO_ESTILOS = "app.css";

    private Stage stage;

    public ControladorBotonIniciarJuego(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        ModeloJuego modelo = ModeloJuego.obtenerInstancia();
        ControladorJuego controlador = new ControladorJuego(modelo, this.stage);

        VistaJuego vista = new VistaJuego(controlador, modelo, this.stage);
        Scene scene = new Scene(vista.getNodoRaiz());
        this.cargarEstilos(scene);
        vista.inicializarMovimiento(scene);

        stage.setScene(scene);
    }

    private void cargarEstilos(Scene scene) {
        String archivoEstilos = App.class.getResource(ARCHIVO_ESTILOS).toExternalForm();
        // TODO: Descubrir como mejorar la parte esta.
        scene.getStylesheets().add(archivoEstilos);
    }
}
