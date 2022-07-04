package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonAyuda implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;
    private boolean estaJugando;

    public ControladorBotonAyuda(ControladorCambioDePantallas controladorCambioPantallas, boolean estaJugando) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.estaJugando = estaJugando;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.controladorCambioPantallas.cargarPantallaAyuda(this.estaJugando);
    }
}
