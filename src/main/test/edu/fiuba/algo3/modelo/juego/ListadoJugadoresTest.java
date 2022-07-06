package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ListadoJugadoresTest {
    private static final Posicion POSICION_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final GeneradorMapa GENERADOR_MAPA = new GeneradorMapa(10, 10, new Posicion(0, 0));

    @Test
    public void dadosUnosJugadoresAlCrearElJugadorEnTurnoEnElListadoEsElPrimerJugadorDeLaListaDada() {
        ListadoJugadores listadoJugadores = new ListadoJugadores();

        Jugador jugador1 = new Jugador("nombre", POSICION_INICIAL_JUGADOR, new Moto());
        Jugador jugador2 = new Jugador("nombre", POSICION_INICIAL_JUGADOR, new Moto());
        listadoJugadores.agregarJugador(jugador1);
        listadoJugadores.agregarJugador(jugador2);

        Jugador jugadorEnTurnoEsperado = jugador1;
        Jugador jugadorEnTurnoActual = listadoJugadores.getJugadorEnTurno();

        assertEquals(jugadorEnTurnoEsperado, jugadorEnTurnoActual);
    }

    @Test
    public void siNoSeHanAgregadoJugadoresAUnListadoDeJugadoresNoSePuedeObtenerElJugadorEnTurno() {
        ListadoJugadores listadoJugadores = new ListadoJugadores();

        Exception excepcion = assertThrows(RuntimeException.class, () -> {
            listadoJugadores.getJugadorEnTurno();
        });

        String mensajeEsperado = "La partida debe tener al menos un jugador";
        String mensajeRecibido = excepcion.getMessage();

        assertEquals(mensajeEsperado, mensajeRecibido);
    }

    @Test
    public void siNoSeHanAgregadoJugadoresAUnListadoDeJugadoresNoSePuedeJugarElTurnoDelSiguienteJugador() {
        ListadoJugadores listadoJugadores = new ListadoJugadores();

        Exception excepcion = assertThrows(RuntimeException.class, () -> {
            listadoJugadores.turnoSiguienteJugador(new Partida(GENERADOR_MAPA));
        });

        String mensajeEsperado = "La partida debe tener al menos un jugador";
        String mensajeRecibido = excepcion.getMessage();

        assertEquals(mensajeEsperado, mensajeRecibido);
    }
}
