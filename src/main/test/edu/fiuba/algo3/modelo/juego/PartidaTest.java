package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class PartidaTest {
    @Test
    public void dadaUnaListaDeJugadoresAlCrearUnaPartidaSeCreaConLosJugadoresCorrectos() {
        List<Jugador> jugadoresRegistrados = new ArrayList<>();

        Jugador jugador1 = new Jugador("nombre", new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador("nombre", new Posicion(0, 0), new Moto());

        jugadoresRegistrados.add(jugador1);
        jugadoresRegistrados.add(jugador2);

        Partida partida = new Partida(jugadoresRegistrados, new GeneradorMapa(5, 5, new Posicion(0, 0)));

        List<Jugador> listadoJugadoresPartida = partida.getListadoJugadores();

        assertTrue(listadoJugadoresPartida.contains(jugador1));
        assertTrue(listadoJugadoresPartida.contains(jugador2));
    }
}
