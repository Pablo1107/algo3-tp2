package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vista.juego.VistaPantallaRegistrarJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorIniciarPartida implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;
    private final VistaPantallaRegistrarJugadores vistaPantallaRegistrarJugadores;

    public ControladorIniciarPartida(ControladorCambioDePantallas controladorCambioPantallas, VistaPantallaRegistrarJugadores vistaPantallaRegistrarJugadores) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.vistaPantallaRegistrarJugadores = vistaPantallaRegistrarJugadores;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            this.controladorCambioPantallas.cargarPantallaPartida(Juego.getInstancia().getPartidaActual());
            this.vistaPantallaRegistrarJugadores.borrarAlerta();
        } catch (Exception e) {
            this.vistaPantallaRegistrarJugadores.setAlerta(e.getMessage());
        }
    }
}
