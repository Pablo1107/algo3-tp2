package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Juego {
    private static final Posicion POSICION_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();
    private static final int MAPA_LIMITE_X = 15;
    private static final int MAPA_LIMITE_Y = 10;
    private static final GeneradorMapa GENERADOR_MAPA = new GeneradorMapa(MAPA_LIMITE_X, MAPA_LIMITE_Y, POSICION_INICIAL_JUGADOR);

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
        this.partida = new Partida(GENERADOR_MAPA);
    }

    public void agregarJugadorAPartida(String nombre) {
        Jugador jugador = new Jugador(nombre, POSICION_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
        Juego.getInstancia().getPartidaActual().agregarJugador(jugador);
    }

    public void reiniciarPartidaActual() {
        this.partida.reiniciar();
    }

    public Partida getPartidaActual() {
        return this.partida;
    }

    public void jugarTurno(Direccion direccion) {
        if (!instancia.getPartidaActual().estaEnCurso()) {
            return;
        }

        this.partida.turnoJugadorActual(direccion);
    }
}
