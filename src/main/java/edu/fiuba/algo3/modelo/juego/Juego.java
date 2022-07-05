package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.List;

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
    private List<Jugador> jugadoresRegistrados;

    public static Juego getInstancia() {
        if (instancia == null) {
            instancia = new Juego();
        }

        return instancia;
    }

    private Juego() {
        this.partida = null;
        this.jugadoresRegistrados = new ArrayList<>();
    }

    public void registrarJugador(String nombre) {
        this.jugadoresRegistrados.add(new Jugador(nombre, POSICION_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR));
    }

    public boolean iniciarNuevaPartida() {
        try {
            this.partida = new Partida(this.jugadoresRegistrados, GENERADOR_MAPA);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void turnoJugadorActual(Direccion direccion) {
        if (this.hayPartidaEnCurso()) {
            this.partida.turnoJugadorActual(direccion);
        }
    }

    public void reiniciarPartidaActual() {
        this.partida = new Partida(this.jugadoresRegistrados, GENERADOR_MAPA);
    }

    public void finalizarPartidaActual() {
        if (this.hayPartidaEnCurso()) {
            this.jugadoresRegistrados = new ArrayList<>();
            this.partida = null;
        }
    }

    public Partida getPartidaActual() {
        return this.partida;
    }

    public boolean hayPartidaEnCurso() {
        return this.partida != null;
    }
}
