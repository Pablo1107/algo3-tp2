package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonCerrarJuego implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}
