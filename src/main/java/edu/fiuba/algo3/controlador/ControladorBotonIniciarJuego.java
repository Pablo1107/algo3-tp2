package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonIniciarJuego implements EventHandler<ActionEvent> {
    private final ControladorCambioPantallas controladorCambioPantallas;

    public ControladorBotonIniciarJuego(ControladorCambioPantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent evento) {
        this.controladorCambioPantallas.cargarPantallaJuego();
    }
}
