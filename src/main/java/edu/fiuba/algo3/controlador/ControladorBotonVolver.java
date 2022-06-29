package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

public class ControladorBotonVolver implements EventHandler<ActionEvent> {
    private ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorBotonVolver(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.controladorCambioPantallas.cargarPantallaInicio();
    }
}
