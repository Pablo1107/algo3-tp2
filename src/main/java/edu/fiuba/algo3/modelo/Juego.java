package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    public static boolean corriendo;
    private Jugador jugador;
    private Mapa mapa;
    private List<Integer> puntuaciones;

    //private Thread gameThread;

    public Juego(Jugador jugador, Mapa mapa) {
        corriendo = false;
        this.jugador = jugador;
        this.mapa = mapa;
        this.puntuaciones = new ArrayList<>();
    }

    public void comenzarJuegoNuevo() {
        corriendo = true;
    }

    public void jugar() {
    }

    public void turno(Posicion direccion) {
    }

    private void sigueCorriendo(Mapa mapa) {
        corriendo = mapa.sigueCorriendo(jugador.getPosicion());
    }
}
