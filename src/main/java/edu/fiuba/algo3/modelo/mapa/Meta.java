package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Meta extends Elemento {
    public Meta(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void chocarCon(Jugador jugador) {
        Partida partidaActual = Juego.getInstancia().getPartidaActual();
        partidaActual.turnoSiguienteJugador();
    }
}
