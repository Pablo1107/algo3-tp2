package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class Juego {
    private static final int MAPA_LIMITE_X = 15;
    private static final int MAPA_LIMITE_Y = 10;
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
        listadoJugadores.add(new Jugador(new Posicion(0, 0), new Auto()));
        listadoJugadores.add(new Jugador(new Posicion(0, 0), new CuatroXCuatro()));

        this.partida = new Partida(listadoJugadores, new GeneradorMapa(MAPA_LIMITE_X, MAPA_LIMITE_Y));
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
