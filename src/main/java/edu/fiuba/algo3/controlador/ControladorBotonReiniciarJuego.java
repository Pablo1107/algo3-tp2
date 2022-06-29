package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.ModeloJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonReiniciarJuego implements EventHandler<ActionEvent> {
    private static final String ARCHIVO_ESTILOS = "app.css";

    private ModeloJuego modelo;
    private Stage stage;

    public ControladorBotonReiniciarJuego(ModeloJuego modelo, Stage stage) {
        this.modelo = modelo;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // this.modelo.reiniciar();
        //
        // ControladorTecladoJuego controlador = new ControladorTecladoJuego(this.modelo, this.stage);
        //
        // VistaPantallaJuego root = new VistaPantallaJuego(controlador, this.modelo, this.stage);
        // Scene scene = new Scene(root.getNodoRaiz());
        // root.inicializarMovimiento(scene);
        // this.cargarEstilos(scene);
        // this.stage.setScene(scene);
        // System.out.println(this.stage);
    }

    private void cargarEstilos(Scene scene) {
        String archivoEstilos = App.class.getResource(ARCHIVO_ESTILOS).toExternalForm();
        // TODO: Descubrir como mejorar la parte esta.
        scene.getStylesheets().add(archivoEstilos);
    }
}
