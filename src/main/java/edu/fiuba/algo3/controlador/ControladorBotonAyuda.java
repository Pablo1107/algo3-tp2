package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonAyuda implements EventHandler<ActionEvent> {
    private final ControladorCambioPantallas controladorCambioPantallas;

    public ControladorBotonAyuda(ControladorCambioPantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.controladorCambioPantallas.cargarPantallaAyuda();
    }
}
