package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ControladorAgregarJugador {
    private final List<Jugador> listadoJugadores;

    public ControladorAgregarJugador() {
        this.listadoJugadores = new ArrayList<>();
    }

    public void agregarJugador(String nombreJugador) {
        Juego.getInstancia().agregarJugador(nombreJugador);
    }
}
