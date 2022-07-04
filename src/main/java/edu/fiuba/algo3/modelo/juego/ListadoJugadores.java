package edu.fiuba.algo3.modelo.juego;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ListadoJugadores {
    private final List<Jugador> listadoJugadores;
    private int indiceJugadorEnTurno;

    public ListadoJugadores(List<Jugador> listadoJugadores) {
        this.listadoJugadores = listadoJugadores;
        this.indiceJugadorEnTurno = 0;
    }

    public Jugador getJugadorEnTurno() {
        return this.listadoJugadores.get(this.indiceJugadorEnTurno);
    }

    public void turnoSiguienteJugador(Partida partidaActual) {
        if (!partidaActual.estaEnCurso()) {
            return;
        }

        if (this.indiceJugadorEnTurno >= (this.listadoJugadores.size() - 1)) {
            partidaActual.finalizar();
            this.indiceJugadorEnTurno = 0;
        }

        this.indiceJugadorEnTurno++;
    }

    public List<Jugador> getListadoJugadores() {
        return this.listadoJugadores;
    }
}
