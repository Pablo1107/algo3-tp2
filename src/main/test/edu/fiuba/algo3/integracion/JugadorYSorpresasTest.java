package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Favorable;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorYSorpresasTest {
    @Test
    public void cuandoUnJugadorChocaConUnaSopresaFavorableSusMovimentosSeReducenEnUn25PorCierto() {
        Posicion posicionInicial = new Posicion(0, 0);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Mapa mapa = new Mapa(10, 10);
        Posicion posicionSorpresa = new Posicion(1, 0);
        Favorable sorpresa = new Favorable(posicionSorpresa);

        mapa.agregarElemento(sorpresa);
        jugador.setMovimientos(19);

        Posicion direccion = new Posicion(1, 0);
        jugador.avanzar(direccion, mapa);

        int movimientosEsperados = 16;
        int movimientosActuales = jugador.getMovimientos();

        assertEquals(movimientosEsperados, movimientosActuales);
    }

    @Test
    public void cuandoUnJugadorChocaconUnaSorpresaDesfavorableSusMovimientosSeAumentanEnUn20PorCierto() {
        Posicion posicionInicial = new Posicion(0, 0);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Mapa mapa = new Mapa(10, 10);
        Posicion posicionSorpresa = new Posicion(1, 0);
        Desfavorable sorpresa = new Desfavorable(posicionSorpresa);

        mapa.agregarElemento(sorpresa);
        jugador.setMovimientos(19);

        Posicion direccion = new Posicion(1, 0);
        jugador.avanzar(direccion, mapa);

        int movimientosEsperados = 25;
        int movimientosActuales = jugador.getMovimientos();

        assertEquals(movimientosEsperados, movimientosActuales);
    }
}