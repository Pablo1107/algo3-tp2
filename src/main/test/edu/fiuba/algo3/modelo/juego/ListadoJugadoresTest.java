package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ListadoJugadoresTest {
    @Test
    public void dadaUnaListaDeJugadoresAlIterarSobreLaListaSeObtieneElSiguienteJugador() {
        Jugador jugador1 = new Jugador(new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador(new Posicion(0, 0), new Moto());
        Jugador jugador3 = new Jugador(new Posicion(0, 0), new Moto());

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        ListadoJugadores listadoJugadores = new ListadoJugadores(jugadores);
        Iterator<Jugador> iteradorListadoJugadores = listadoJugadores.iterator();

        assertEquals(iteradorListadoJugadores.next(), jugador1);
        assertEquals(iteradorListadoJugadores.next(), jugador2);
        assertEquals(iteradorListadoJugadores.next(), jugador3);
    }

    @Test
    public void dadoUnIteradorDeJugadoresAlLlegarAlUltimoJugadorSeVuelveAlPrimerJugadorDeLaLista() {
        Jugador jugador1 = new Jugador(new Posicion(0, 0), new Moto());
        Jugador jugador2 = new Jugador(new Posicion(0, 0), new Moto());

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        ListadoJugadores listadoJugadores = new ListadoJugadores(jugadores);
        Iterator<Jugador> iteradorListadoJugadores = listadoJugadores.iterator();

        assertEquals(iteradorListadoJugadores.next(), jugador1);
        assertEquals(iteradorListadoJugadores.next(), jugador2);
        assertEquals(iteradorListadoJugadores.next(), jugador1);
    }
}
