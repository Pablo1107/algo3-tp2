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
        List<Jugador> listadoJugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador(new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador(new Posicion(0, 1), new Moto());
        listadoJugadores.add(jugador1);
        listadoJugadores.add(jugador2);

        ListadoJugadores listadoJugadoresPartida = new ListadoJugadores(listadoJugadores);

        Jugador jugadorEnTurnoEsperado = jugador1;
        Jugador jugadorEnTurnoActual = listadoJugadoresPartida.getJugadorEnTurno();

        assertEquals(jugadorEnTurnoEsperado, jugadorEnTurnoActual);
    }

    @Test
    public void dadaUnaListaDeJugadoresSeGuardaLaListaDadaEnElListado() {
        List<Jugador> listadoJugadores = new ArrayList<>();
        listadoJugadores.add(new Jugador(new Posicion(0, 0), new Moto()));
        listadoJugadores.add(new Jugador(new Posicion(0, 1), new Moto()));

        ListadoJugadores listadoJugadoresPartida = new ListadoJugadores(listadoJugadores);

        List<Jugador> listadoJugadoresEsperado = listadoJugadores;
        List<Jugador> listadoJugadoresActual = listadoJugadoresPartida.getListadoJugadores();

        assertEquals(listadoJugadoresEsperado, listadoJugadoresActual);
    }
}
