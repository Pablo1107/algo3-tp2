package edu.fiuba.algo3.modelo.juego;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ListadoJugadores {
    private List<Jugador> jugadoresRegistrados;
    private int indiceJugadorEnTurno;

    public ListadoJugadores(List<Jugador> jugadoresRegistrados) {
        if (jugadoresRegistrados.size() == 0) {
            throw new RuntimeException("Sin jugadores registrados");
        }

        this.jugadoresRegistrados = jugadoresRegistrados;
        this.indiceJugadorEnTurno = 0;
    }

    public void turnoSiguienteJugador() {
        if (this.indiceJugadorEnTurno >= (this.jugadoresRegistrados.size() - 1)) {
            Juego.getInstancia().finalizarPartidaActual();
        }

        this.indiceJugadorEnTurno++;
    }

    public Jugador getJugadorEnTurno() {
        return this.jugadoresRegistrados.get(this.indiceJugadorEnTurno);
    }

    public List<Jugador> getListadoJugadores() {
        return this.jugadoresRegistrados;
    }
}
