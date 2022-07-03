package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;

public class PartidaTest {
    @Test
    public void dadoUnListadoDeJugadoresEstosSeGuardanCorrectamenteEnLaPartida() {
        Jugador jugador1 = new Jugador(new Posicion(0, 0), new Auto());
        Jugador jugador2 = new Jugador(new Posicion(0, 0), new Auto());

        List<Jugador> listadoJugadores = new ArrayList<>();
        listadoJugadores.add(jugador1);
        listadoJugadores.add(jugador2);

        Partida partida = new Partida(listadoJugadores, new Mapa(10, 10));

        List<Jugador> jugadoresGuardados = partida.getListadoJugadores();

        assertTrue(jugadoresGuardados.contains(jugador1));
        assertTrue(jugadoresGuardados.contains(jugador2));
    }

    @Test
    public void dadaUnaPartidaAlJugarUnTurnoSeJuegaElTurnoDelJugadorCorrespondiente() {
        Jugador jugador1 = new Jugador(new Posicion(0, 0), new Auto());
        Jugador jugador2 = new Jugador(new Posicion(0, 0), new Auto());

        List<Jugador> listadoJugadores = new ArrayList<>();
        listadoJugadores.add(jugador1);
        listadoJugadores.add(jugador2);

        Partida partida = new Partida(listadoJugadores, new Mapa(10, 10));

        partida.jugarTurno(new Direccion(1, 0)); // Deberia moverse el primer jugador.
        assertEquals(new Posicion(1, 0), jugador1.getPosicion());
        assertEquals(1, jugador1.getMovimientos());

        partida.jugarTurno(new Direccion(1, 0)); // Deberia moverse el segundo jugador.
        assertEquals(new Posicion(1, 0), jugador2.getPosicion());
        assertEquals(1, jugador2.getMovimientos());

        partida.jugarTurno(new Direccion(1, 0)); // Deberia moverse el primer jugador de nuevo.
        assertEquals(new Posicion(2, 0), jugador1.getPosicion());
        assertEquals(2, jugador1.getMovimientos());
    }
}
