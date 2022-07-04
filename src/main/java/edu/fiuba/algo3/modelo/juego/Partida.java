package edu.fiuba.algo3.modelo.juego;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;

public class Partida {
    private static final int MAPA_LIMITE_X = 15;
    private static final int MAPA_LIMITE_Y = 10;

    private List<Jugador> listadoJugadores;
    private GeneradorMapa generadorMapa;
    private boolean estaEnCurso;

    public Partida(List<Jugador> listadoJugadores) {
        this.estaEnCurso = true;
        this.listadoJugadores = listadoJugadores;
        this.iniciarNuevaPartida();
    }

    public void iniciarNuevaPartida() {
        this.estaEnCurso = true;
        this.generadorMapa = new GeneradorMapa(MAPA_LIMITE_X, MAPA_LIMITE_Y);
    }

    public void jugarTurno(Direccion direccion) {
        this.getJugador().avanzar(direccion, this.generadorMapa.getMapa());
    }

    public Jugador getJugador() {
        return this.listadoJugadores.get(0);
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
}
