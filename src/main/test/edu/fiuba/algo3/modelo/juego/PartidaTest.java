package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class PartidaTest {
    @Test
    public void cuandoSeJuegaElTurnoEnUnaPartidaEfectivamenteSeJuegaElTurnoParaElJugadorEnTurno() {
        Partida partida = new Partida();

        partida.agregarJugador("nombre");

        partida.jugarTurnoJugadorActual(new Direccion(1, 0));

        Jugador jugador = partida.getJugadorEnTurno();
        Posicion posicionJugadorEsperada = new Posicion(1, 0);
        Posicion posicionJugadorActual = jugador.getPosicion();

        assertEquals(posicionJugadorEsperada, posicionJugadorActual);

        int movimientosJugadorEsperados = 1;
        int movimientosJugadorActuales = jugador.getMovimientos();

        assertEquals(movimientosJugadorEsperados, movimientosJugadorActuales);
    }

    @Test
    public void alCrearUnaPartidaEstaEstaEnCurso() {
        Partida partida = new Partida();
        assertTrue(partida.estaEnCurso());
    }

    @Test
    public void alFinalizarUnaPartidaEstaNoEstaEnCurso() {
        Partida partida = new Partida();
        partida.finalizar();
        assertFalse(partida.estaEnCurso());
    }
}
