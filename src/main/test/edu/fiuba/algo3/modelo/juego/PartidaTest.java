package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.mapa.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class PartidaTest {
    private static final GeneradorMapa GENERADOR_MAPA = new GeneradorMapa(10, 10, new Posicion(0, 0));

    @Test
    public void dadosUnosJugadoresAlIniciarUnaPartidaElJugadorEnTurnoEsElPrimerJugadorAgregado() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("nombre", new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador("nombre", new Posicion(0, 1), new Moto());
        listadoJugadores.add(jugador1);
        listadoJugadores.add(jugador2);

        Partida partida = new Partida(GENERADOR_MAPA);

        partida.agregarJugador(jugador1);
        partida.agregarJugador(jugador2);

        Jugador jugadorEnTurnoEsperado = jugador1;
        Jugador jugadorEnTurnoActual = partida.getJugadorEnTurno();

        assertEquals(jugadorEnTurnoEsperado, jugadorEnTurnoActual);
    }

    @Test
    public void dadoUnGeneradorDeMapaAlCrearUnaPartidaSeCreaElMapaCorrecto() {
        Partida partida = new Partida(GENERADOR_MAPA);

        Mapa mapaGeneradoPorElGenerador = GENERADOR_MAPA.getMapa();
        Mapa mapaActualDeLaPartida = partida.getMapa();

        assertEquals(mapaGeneradoPorElGenerador, mapaActualDeLaPartida);
    }

    @Test
    public void dadoUnGeneradorDeMapaAlCrearUnaPartidaSeCreaLaMetaCorrecta() {
        Partida partida = new Partida(GENERADOR_MAPA);

        Meta metaGeneradaPorElGenerador = GENERADOR_MAPA.getMeta();
        Meta metaActualDeLaPartida = partida.getMeta();

        assertEquals(metaGeneradaPorElGenerador, metaActualDeLaPartida);
    }

    @Test
    public void alCrearUnaPartidaEstaEstaEnCurso() {
        Partida partida = new Partida(GENERADOR_MAPA);

        assertTrue(partida.estaEnCurso());
    }

    @Test
    public void luegoDeFinalizarUnaPartidaEstaNoEstaEnCurso() {
        Partida partida = new Partida(GENERADOR_MAPA);
        partida.finalizar();

        assertFalse(partida.estaEnCurso());
    }

    @Test
    public void alCederleElTurnoAlSiguienteJugadorDeUnaPartidaElNuevoJugadorEnTurnoEsElEsperado() {
        Jugador jugador1 = new Jugador("nombre", new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador("nombre", new Posicion(0, 1), new Moto());
        Jugador jugador3 = new Jugador("nombre", new Posicion(0, 2), new Moto());

        Partida partida = new Partida(GENERADOR_MAPA);

        partida.agregarJugador(jugador1);
        partida.agregarJugador(jugador2);
        partida.agregarJugador(jugador3);

        Jugador jugadorEnTurnoEsperado;
        Jugador jugadorEnTurnoActual;

        partida.turnoSiguienteJugador();

        jugadorEnTurnoEsperado = jugador2;
        jugadorEnTurnoActual = partida.getJugadorEnTurno();

        assertEquals(jugadorEnTurnoEsperado, jugadorEnTurnoActual);

        partida.turnoSiguienteJugador();

        jugadorEnTurnoEsperado = jugador3;
        jugadorEnTurnoActual = partida.getJugadorEnTurno();

        assertEquals(jugadorEnTurnoEsperado, jugadorEnTurnoActual);
    }

    @Test
    public void cuandoTodosLosJugadoresDeUnaPartidaTerminanSuTurnoSeFinalizaLaPartida() {
        Partida partida = new Partida(GENERADOR_MAPA);

        partida.agregarJugador(new Jugador("nombre", new Posicion(0, 0), new Moto()));
        partida.agregarJugador(new Jugador("nombre", new Posicion(0, 1), new Moto()));

        partida.turnoSiguienteJugador();
        partida.turnoSiguienteJugador();

        assertFalse(partida.estaEnCurso());
    }

    @Test
    public void cuandoSeJuegaElTurnoEnUnaPartidaEfectivamenteSeJuegaElTurnoParaElJugadorEnTurno() {
        Partida partida = new Partida(GENERADOR_MAPA);

        Jugador jugador = new Jugador("nombre", new Posicion(0, 0), new Moto());
        partida.agregarJugador(jugador);

        partida.turnoJugadorActual(new Direccion(1, 0));

        Posicion posicionJugadorEsperada = new Posicion(1, 0);
        Posicion posicionJugadorActual = jugador.getPosicion();

        assertEquals(posicionJugadorEsperada, posicionJugadorActual);

        int movimientosJugadorEsperados = 1;
        int movimientosJugadorActuales = jugador.getMovimientos();

        assertEquals(movimientosJugadorEsperados, movimientosJugadorActuales);
    }

    @Test
    public void alCrearUnaPartidaConCiertosJugadoresTodosLosJugadoresEsperadosJueganLaPartida() {
        Partida partida = new Partida(GENERADOR_MAPA);

        Jugador jugador1 = new Jugador("nombre", new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador("nombre", new Posicion(0, 1), new Moto());
        Jugador jugador3 = new Jugador("nombre", new Posicion(0, 2), new Moto());

        partida.agregarJugador(jugador1);
        partida.agregarJugador(jugador2);
        partida.agregarJugador(jugador3);

        List<Jugador> listadoJugadores = partida.getListadoJugadores();

        assertTrue(listadoJugadores.contains(jugador1));
        assertTrue(listadoJugadores.contains(jugador2));
        assertTrue(listadoJugadores.contains(jugador3));
    }

    @Test
    public void cuandoSeReiniciaUnaPartidaTodosLosJugadoresVuelvenALaPosicionInicial() {
        Partida partida = new Partida(GENERADOR_MAPA);

        Posicion posicionInicial1 = new Posicion(0, 0);
        Jugador jugador1 = new Jugador("nombre", posicionInicial1, new Moto());
        
        Posicion posicionInicial2 = new Posicion(0, 2);
        Jugador jugador2 = new Jugador("nombre", posicionInicial2, new Moto());

        partida.agregarJugador(jugador1);
        partida.agregarJugador(jugador2);

        partida.turnoJugadorActual(new Direccion(1, 0));
        partida.turnoJugadorActual(new Direccion(1, 0));
        partida.turnoSiguienteJugador();
        partida.turnoJugadorActual(new Direccion(1, 0));
        partida.turnoJugadorActual(new Direccion(1, 0));

        partida.reiniciar();

        Posicion posicionActual1 = jugador1.getPosicion();
        assertEquals(posicionInicial1, posicionActual1);

        Posicion posicionActual2 = jugador2.getPosicion();
        assertEquals(posicionInicial2, posicionActual2);
    }

    public void seGeneraUnaPartidaYSeObtieneUnElemento() {
        Partida partida = new Partida(new GeneradorMapa(10, 10, new Posicion(0, 0)));
        partida.agregarJugador(new Jugador("nombre", new Posicion(0, 0), new Moto()));

        Elemento elementoEnPosicionInicial = partida.getElementoEnTurno();
        assertTrue(elementoEnPosicionInicial instanceof ElementoNulo);
    }
}
