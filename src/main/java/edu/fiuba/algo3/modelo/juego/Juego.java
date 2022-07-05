package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.mapa.Direccion;

public class Juego {
    private static Juego instancia;

    private Partida partida;

    public static Juego getInstancia() {
        if (instancia == null) {
            instancia = new Juego();
        }

        return instancia;
    }

    private Juego() {
        this.iniciarNuevaPartida();
    }

    public void iniciarNuevaPartida() {
        this.partida = new Partida();
    }

    public void reiniciarPartidaActual() {
        this.partida.reiniciar();
    }

    public void finalizarPartidaActual() {
        this.partida.finalizar();
    }

    public void jugarTurno(Direccion direccion) {
        if (instancia.getPartidaActual().estaEnCurso()) {
            this.partida.jugarTurnoJugadorActual(direccion);
        }
    }

    public Partida getPartidaActual() {
        return this.partida;
    }
}
