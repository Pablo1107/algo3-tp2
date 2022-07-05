package edu.fiuba.algo3.modelo.juego;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ListadoJugadoresTest {
    @Test
    public void noSePuedeCrearUnListadoDeJugadoresSinJugadoresRegistrados() {
        List<Jugador> jugadoresRegistrados = new ArrayList<>();

        Exception excepcion = assertThrows(RuntimeException.class, () -> new ListadoJugadores(jugadoresRegistrados));

        String mensajeEsperado = "Sin jugadores registrados";
        String mensajeRecibido = excepcion.getMessage();

        assertEquals(mensajeEsperado, mensajeRecibido);
    }

    @Test
    public void dadaUnaListaDeJugadoresRegistradosAlCrearElJugadorEnTurnoEnElListadoEsElPrimerJugadorDeLaListaDada() {
        List<Jugador> jugadoresRegistrados = new ArrayList<>();

        Jugador primerJugador = new Jugador("nombre", new Posicion(0, 0), new Moto());

        jugadoresRegistrados.add(primerJugador);
        jugadoresRegistrados.add(new Jugador("nombre", new Posicion(0, 0), new Moto()));

        ListadoJugadores listadoJugadores = new ListadoJugadores(jugadoresRegistrados);

        Jugador jugadorEnTurnoEsperado = primerJugador;
        Jugador jugadorEnTurnoActual = listadoJugadores.getJugadorEnTurno();

        assertEquals(jugadorEnTurnoEsperado, jugadorEnTurnoActual);
    }

    @Test
    public void dadaUnaListaDeJugadoresSeGuardaLaListaDadaEnElListado() {
        List<Jugador> listadoJugadoresOriginal = new ArrayList<>();

        Jugador jugador1 = new Jugador("nombre", new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador("nombre", new Posicion(0, 0), new Moto());

        listadoJugadoresOriginal.add(jugador1);
        listadoJugadoresOriginal.add(jugador2);

        Partida partida = new Partida(listadoJugadoresOriginal, new GeneradorMapa(5, 5, new Posicion(0, 0)));

        List<Jugador> listadoJugadoresPartida = partida.getListadoJugadores();

        assertTrue(listadoJugadoresPartida.contains(jugador1));
        assertTrue(listadoJugadoresPartida.contains(jugador2));
    }
}
