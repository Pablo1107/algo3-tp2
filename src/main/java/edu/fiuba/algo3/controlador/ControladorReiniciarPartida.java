package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorReiniciarPartida implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorReiniciarPartida(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Partida partidaActual = Juego.getInstancia().getPartidaActual();
        partidaActual.reiniciar();
        this.controladorCambioPantallas.cargarPantallaPartida(partidaActual);
    }
}
