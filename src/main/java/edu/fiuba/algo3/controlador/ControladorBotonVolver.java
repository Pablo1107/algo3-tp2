package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

public class ControladorBotonVolver implements EventHandler<ActionEvent> {
    private ControladorCambioPantallas controladorCambioPantallas;

    public ControladorBotonVolver(ControladorCambioPantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.controladorCambioPantallas.cargarPantallaInicio();
    }
}
