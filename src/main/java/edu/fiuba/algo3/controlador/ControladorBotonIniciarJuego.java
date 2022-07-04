package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonIniciarJuego implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorBotonIniciarJuego(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent evento) {
        this.controladorCambioPantallas.cargarPantallaPartida();
    }
}
