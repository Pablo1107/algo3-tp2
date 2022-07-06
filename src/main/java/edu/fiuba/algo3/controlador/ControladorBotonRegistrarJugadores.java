package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonRegistrarJugadores implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorBotonRegistrarJugadores(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent evento) {
        Juego.getInstancia().iniciarNuevaPartida();
        this.controladorCambioPantallas.cargarPantallaRegistrarJugadores();
    }
}
