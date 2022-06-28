package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.juego.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorEventoUnJugador implements EventHandler<ActionEvent> {
    private Stage stage;
    private Button boton;

    public ControladorEventoUnJugador(Button boton, Stage stage) {
        this.boton = boton;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ModeloJuego modelo = ModeloJuego.obtenerInstancia();
        ControladorJuego controlador = new ControladorJuego(modelo, this.stage);
        VistaJuego root = new VistaJuego(controlador, modelo, this.stage);
        Scene scene = new Scene(root.getNodoRaiz());
        root.inicializarMovimiento(scene);
        stage.setScene(scene);
    }

}