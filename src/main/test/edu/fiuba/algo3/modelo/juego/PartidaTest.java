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
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class PartidaTest {
    @Test
    public void noSePuedeCrearUnaPartidaSinJugadores() {
        List<Jugador> listadoJugadores = new ArrayList<>();

        Exception excepcion = assertThrows(RuntimeException.class, () -> new Partida(listadoJugadores, new GeneradorMapa(10, 10, new Posicion(0, 0))));

        String mensajeEsperado = "La partida debe tener al menos un jugador";
        String mensajeRecibido = excepcion.getMessage();

        assertEquals(mensajeEsperado, mensajeRecibido);
    }

    @Test
    public void dadaUnaListaDeJugadoresAlCrearUnaPartidaElJugadorEnTurnoEsElPrimerJugadorDeLaListaDada() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("nombre", new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador("nombre", new Posicion(0, 1), new Moto());
        listadoJugadores.add(jugador1);
        listadoJugadores.add(jugador2);

        Partida partida = new Partida(listadoJugadores, new GeneradorMapa(10, 10, new Posicion(0, 0)));

        Jugador jugadorEnTurnoEsperado = jugador1;
        Jugador jugadorEnTurnoActual = partida.getJugadorEnTurno();

        assertEquals(jugadorEnTurnoEsperado, jugadorEnTurnoActual);
    }

    @Test
    public void dadoUnGeneradorDeMapaAlCrearUnaPartidaSeCreaElMapaCorrecto() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        listadoJugadores.add(new Jugador("nombre", new Posicion(0, 0), new Moto()));

        GeneradorMapa generadorMapa = new GeneradorMapa(10, 10, new Posicion(0, 0));
        Partida partida = new Partida(listadoJugadores, generadorMapa);

        Mapa mapaGeneradoPorElGenerador = generadorMapa.getMapa();
        Mapa mapaActualDeLaPartida = partida.getMapa();

        assertEquals(mapaGeneradoPorElGenerador, mapaActualDeLaPartida);
    }

    @Test
    public void dadoUnGeneradorDeMapaAlCrearUnaPartidaSeCreaLaMetaCorrecta() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        listadoJugadores.add(new Jugador("nombre", new Posicion(0, 0), new Moto()));

        GeneradorMapa generadorMapa = new GeneradorMapa(10, 10, new Posicion(0, 0));
        Partida partida = new Partida(listadoJugadores, generadorMapa);

        Meta metaGeneradaPorElGenerador = generadorMapa.getMeta();
        Meta metaActualDeLaPartida = partida.getMeta();

        assertEquals(metaGeneradaPorElGenerador, metaActualDeLaPartida);
    }

    @Test
    public void alCrearUnaPartidaEstaEstaEnCurso() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        listadoJugadores.add(new Jugador("nombre", new Posicion(0, 0), new Moto()));

        Partida partida = new Partida(listadoJugadores, new GeneradorMapa(10, 10, new Posicion(0, 0)));

        assertTrue(partida.estaEnCurso());
    }

    @Test
    public void luegoDeFinalizarUnaPartidaEstaNoEstaEnCurso() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        listadoJugadores.add(new Jugador("nombre", new Posicion(0, 0), new Moto()));

        Partida partida = new Partida(listadoJugadores, new GeneradorMapa(10, 10, new Posicion(0, 0)));
        partida.finalizar();

        assertFalse(partida.estaEnCurso());
    }

    @Test
    public void alCederleElTurnoAlSiguienteJugadorDeUnaPartidaElNuevoJugadorEnTurnoEsElEsperado() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("nombre", new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador("nombre", new Posicion(0, 1), new Moto());
        Jugador jugador3 = new Jugador("nombre", new Posicion(0, 2), new Moto());
        listadoJugadores.add(jugador1);
        listadoJugadores.add(jugador2);
        listadoJugadores.add(jugador3);

        Partida partida = new Partida(listadoJugadores, new GeneradorMapa(10, 10, new Posicion(0, 0)));

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
        List<Jugador> listadoJugadores = new ArrayList<>();
        listadoJugadores.add(new Jugador("nombre", new Posicion(0, 0), new Moto()));
        listadoJugadores.add(new Jugador("nombre", new Posicion(0, 1), new Moto()));

        Partida partida = new Partida(listadoJugadores, new GeneradorMapa(10, 10, new Posicion(0, 0)));

        partida.turnoSiguienteJugador();
        partida.turnoSiguienteJugador();

        assertFalse(partida.estaEnCurso());
    }

    @Test
    public void cuandoSeJuegaElTurnoEnUnaPartidaEfectivamenteSeJuegaElTurnoParaElJugadorEnTurno() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        Jugador jugador = new Jugador("nombre", new Posicion(0, 0), new Moto());
        listadoJugadores.add(jugador);

        Partida partida = new Partida(listadoJugadores, new GeneradorMapa(10, 10, new Posicion(0, 0)));

        partida.jugarTurno(new Direccion(1, 0));

        Posicion posicionJugadorEsperada = new Posicion(1, 0);
        Posicion posicionJugadorActual = jugador.getPosicion();

        assertEquals(posicionJugadorEsperada, posicionJugadorActual);

        int movimientosJugadorEsperados = 1;
        int movimientosJugadorActuales = jugador.getMovimientos();

        assertEquals(movimientosJugadorEsperados, movimientosJugadorActuales);
    }
}
