package edu.fiuba.algo3.modelo.juego;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;

public class Partida {
    private final ListadoJugadores listadoJugadores;
    private final GeneradorMapa generadorMapa;
    private boolean estaEnCurso;

    public Partida(List<Jugador> listadoJugadores, GeneradorMapa generadorMapa) {
        if (listadoJugadores.size() == 0) {
            throw new RuntimeException("La partida debe tener al menos un jugador");
        }

        this.estaEnCurso = true;
        this.listadoJugadores = new ListadoJugadores(listadoJugadores);
        this.generadorMapa = generadorMapa;
    }

    public void jugarTurno(Direccion direccion) {
        this.getJugadorEnTurno().avanzar(direccion, this.generadorMapa.getMapa());
    }

    public Jugador getJugadorEnTurno() {
        return this.listadoJugadores.getJugadorEnTurno();
    }

    public Mapa getMapa() {
        return this.generadorMapa.getMapa();
    }

    public Meta getMeta() {
        return this.generadorMapa.getMeta();
    }

    public boolean estaEnCurso() {
        return this.estaEnCurso;
    }

    public void finalizar() {
        this.estaEnCurso = false;
    }

    public void turnoSiguienteJugador() {
        this.listadoJugadores.turnoSiguienteJugador(this);
    }
}
