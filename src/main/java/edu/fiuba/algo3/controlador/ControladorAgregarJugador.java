package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;

public class ControladorAgregarJugador {
    public void agregarJugador(String nombreJugador) {
        Juego.getInstancia().registrarJugador(nombreJugador);
    }
}
