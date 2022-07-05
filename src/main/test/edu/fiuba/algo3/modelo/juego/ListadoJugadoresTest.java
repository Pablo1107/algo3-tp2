package edu.fiuba.algo3.modelo.juego;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ListadoJugadoresTest {
    @Test
    public void dadaUnaListaDeJugadoresAlCrearElJugadorEnTurnoEnElListadoEsElPrimerJugadorDeLaListaDada() {
        ListadoJugadores listadoJugadores = new ListadoJugadores();

        Jugador jugador1 = new Jugador("nombre", new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador("nombre", new Posicion(0, 1), new Moto());
        listadoJugadores.agregarJugador(jugador1);
        listadoJugadores.agregarJugador(jugador2);

        Jugador jugadorEnTurnoEsperado = jugador1;
        Jugador jugadorEnTurnoActual = listadoJugadores.getJugadorEnTurno();

        assertEquals(jugadorEnTurnoEsperado, jugadorEnTurnoActual);
    }

    @Test
    public void dadaUnaListaDeJugadoresSeGuardaLaListaDadaEnElListado() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("nombre", new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador("nombre", new Posicion(0, 1), new Moto());

        listadoJugadores.add(jugador1);
        listadoJugadores.add(jugador2);

        ListadoJugadores listadoJugadoresPartida = new ListadoJugadores();
        listadoJugadoresPartida.agregarJugador(jugador1);
        listadoJugadoresPartida.agregarJugador(jugador2);

        List<Jugador> listadoJugadoresEsperado = listadoJugadores;
        List<Jugador> listadoJugadoresActual = listadoJugadoresPartida.getListadoJugadores();

        assertEquals(listadoJugadoresEsperado, listadoJugadoresActual);
    }
}
