package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;

import java.util.List;

public class Partida {
    private final ListadoJugadores listadoJugadores;
    private final GeneradorMapa generadorMapa;
    private boolean estaEnCurso;

    public Partida(GeneradorMapa generadorMapa) {
        this.estaEnCurso = true;
        this.listadoJugadores = new ListadoJugadores();
        this.generadorMapa = generadorMapa;
    }

    public void reiniciar() {
        this.estaEnCurso = true;
        this.listadoJugadores.reiniciar();
    }

    public void finalizar() {
        this.estaEnCurso = false;
    }

    public void agregarJugador(Jugador jugador) {
        this.listadoJugadores.agregarJugador(jugador);
    }

    public void turnoJugadorActual(Direccion direccion) {
        if (this.listadoJugadores.getListadoJugadores().size() == 0) {
            return;
        }

        this.getJugadorEnTurno().avanzar(direccion, this.generadorMapa.getMapa());
    }

    public void turnoSiguienteJugador() {
        this.listadoJugadores.turnoSiguienteJugador(this);
    }

    public Jugador getJugadorEnTurno() {
        return this.listadoJugadores.getJugadorEnTurno();
    }

    public List<Jugador> getListadoJugadores() {
        return this.listadoJugadores.getListadoJugadores();
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

    public Elemento getElementoEnTurno() {
        return this.getMapa().getElementoEnPosicion(this.getJugadorEnTurno().getPosicion());
    }
}
