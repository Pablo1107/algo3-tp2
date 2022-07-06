package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorVolverAPantallaAnterior implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;
    private boolean estaJugando;

    public ControladorVolverAPantallaAnterior(ControladorCambioDePantallas controladorCambioPantallas, boolean estaJugando) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.estaJugando = estaJugando;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Partida partidaActual = Juego.getInstancia().getPartidaActual();
        if(this.estaJugando) {
            this.controladorCambioPantallas.cargarPantallaPartida(partidaActual);
            return;
        } 

        this.controladorCambioPantallas.cargarPantallaInicio();
    }
}
