package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorIniciarPartida implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorIniciarPartida(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            this.controladorCambioPantallas.cargarPantallaPartida(Juego.getInstancia().getPartidaActual());
        } catch (Exception e) {
            System.out.println("Se intento crear una partida sin jugadores");
        }
    }
}
