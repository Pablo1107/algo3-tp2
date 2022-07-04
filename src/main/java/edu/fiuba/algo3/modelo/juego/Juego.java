package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

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
        List<Jugador> listadoJugadores = new ArrayList<>();
        listadoJugadores.add(new Jugador(new Posicion(0, 0), new Moto()));
        listadoJugadores.add(new Jugador(new Posicion(0, 1), new Moto()));

        this.partida = new Partida(listadoJugadores);
        this.partida.iniciarNuevaPartida();
    }

    public Partida getPartidaActual() {
        return this.partida;
    }

    public void jugarTurno(Direccion direccion) {
        if (!instancia.getPartidaActual().estaEnCurso()) {
            return;
        }

        this.partida.jugarTurno(direccion);
    }

    public Posicion getPosicionMeta() {
        return this.partida.getMeta().getPosicion();
    }
}
