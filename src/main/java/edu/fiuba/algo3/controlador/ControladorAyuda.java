package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorAyuda implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorAyuda(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.controladorCambioPantallas.cargarPantallaAyuda();
    }
}
