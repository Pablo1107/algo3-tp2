package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ListadoJugadores {
    private final List<Jugador> listadoJugadores;
    private int indiceJugadorEnTurno;

    public ListadoJugadores() {
        this.listadoJugadores = new ArrayList<>();
        this.indiceJugadorEnTurno = 0;
    }

    public void agregarJugador(Jugador jugador) {
        this.listadoJugadores.add(jugador);
    }

    public Jugador getJugadorEnTurno() {
        if (this.listadoJugadores.size() == 0) {
            throw new RuntimeException("La partida debe tener al menos un jugador");
        }

        return this.listadoJugadores.get(this.indiceJugadorEnTurno);
    }

    public void turnoSiguienteJugador(Partida partidaActual) {
        if (this.listadoJugadores.size() == 0) {
            throw new RuntimeException("La partida debe tener al menos un jugador");
        }

        if (!partidaActual.estaEnCurso()) {
            return;
        }

        if (this.indiceJugadorEnTurno >= (this.listadoJugadores.size() - 1)) {
            partidaActual.finalizar();
            this.indiceJugadorEnTurno = 0;
            return;
        }

        this.indiceJugadorEnTurno++;
    }

    public List<Jugador> getListadoJugadores() {
        return this.listadoJugadores;
    }

    // TODO: Claramente tengo que cambiar esto.
    public void reiniciar() {
        this.indiceJugadorEnTurno = 0;
        for(Jugador jugador: this.listadoJugadores) {
            jugador.volverAPosicionInicial();
        }

        for(Jugador jugador: this.listadoJugadores) {
            System.out.println(jugador.getPosicion().getX());
        }
    }
}
