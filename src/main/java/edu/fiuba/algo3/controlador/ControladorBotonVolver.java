package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonVolver implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;
    private boolean estaJugando;

    public ControladorBotonVolver(ControladorCambioDePantallas controladorCambioPantallas, boolean estaJugando) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.estaJugando = estaJugando;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.estaJugando) {
            this.controladorCambioPantallas.cargarPantallaPartida();
        } else {
            this.controladorCambioPantallas.cargarPantallaInicio();
        }
    }
}
