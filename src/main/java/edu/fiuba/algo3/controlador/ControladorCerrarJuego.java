package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorCerrarJuego implements EventHandler<ActionEvent> {
    private Button boton;
    public ControladorCerrarJuego(Button cerrarBoton) {
        this.boton = cerrarBoton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}
