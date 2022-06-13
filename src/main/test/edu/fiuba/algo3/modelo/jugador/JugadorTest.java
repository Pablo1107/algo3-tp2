package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void alCrearUnJugadorEsteEstaUbicadoEnLaPosicionEspecificada() {
        Posicion posicionInicial = new Posicion(10, 10);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Posicion posicionEsperada = posicionInicial;
        Posicion posicionActual = jugador.getPosicion();

        assertEquals(posicionEsperada, posicionActual);
    }

    @Test
    public void alCrearUnJugadorEsteTieneElVehiculoEspecificado() {
        Posicion posicionInicial = new Posicion(0, 0);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Posicion posicionEsperada = posicionInicial;
        Posicion posicionActual = jugador.getPosicion();

        assertEquals(posicionEsperada, posicionActual);
    }

    @Test
    public void unJugadorEsCreadoConCeroMovimientos() {
        Posicion posicionInicial = new Posicion(10, 10);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        int movimientosEsperados = 0;
        int movimientosActuales = jugador.getMovimientos();

        assertEquals(movimientosEsperados, movimientosActuales);
    }

    @Test
    public void alMoverUnJugadorDePosicionLaNuevaPosicionDelJugadorEsLaEsperada() {
        Posicion posicionInicial = new Posicion(0, 0);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Posicion direccion = new Posicion(1, 0);
        Mapa mapa = new Mapa(10, 10);

        jugador.avanzar(direccion, mapa);

        Posicion posicionEsperada = new Posicion(1, 0);
        Posicion posicionActual = jugador.getPosicion();

        assertEquals(posicionActual, posicionEsperada);
    }

    @Test
    public void alMoverUnJugadorFueraDelMapaEsteQuedaEnLaMismaPosicionQueTeniaAntes() {
        Posicion posicionInicial = new Posicion(0, 0);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Mapa mapa = new Mapa(5, 5);
        Posicion direccion = new Posicion(10, 10);

        jugador.avanzar(direccion, mapa);

        Posicion posicionActual = jugador.getPosicion();
        Posicion posicionEsperada = posicionInicial;

        assertEquals(posicionEsperada, posicionActual);
    }

    @Test
    public void alMoverUnJugadorSuCantidadDeMovimientosAumentaEnUno() {
        Posicion posicionInicial = new Posicion(0, 0);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Mapa mapa = new Mapa(5, 5);
        Posicion direccion = new Posicion(1, 0);

        jugador.avanzar(direccion, mapa);

        int movimientosEsperados = 1;
        int movimientosActuales = jugador.getMovimientos();

        assertEquals(movimientosEsperados, movimientosActuales);
    }

    @Test
    public void alRetrocederUnJugadorSuPosicionVuelveASerLaAnterior() {
        Posicion posicionInicial = new Posicion(4, 5);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Mapa mapa = new Mapa(10, 10);
        Posicion direccion = new Posicion(1, 0);

        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa);

        Posicion posicionEsperada = new Posicion(6, 5);
        Posicion posicionActual = jugador.getPosicion();

        assertEquals(posicionEsperada, posicionActual);

        jugador.retroceder();

        posicionEsperada = new Posicion(5, 5);
        posicionActual = jugador.getPosicion();

        assertEquals(posicionEsperada, posicionActual);
    }

    @Test
    public void alRetrocederUnJugadorQueNoSeHaMovidoEsteQuedaEnLaMismaPosicionQueTeniaAntes() {
        Posicion posicionInicial = new Posicion(1, 1);
        Vehiculo vehiculo = new Moto();

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        jugador.retroceder();

        Posicion posicionEsperada = posicionInicial;
        Posicion posicionActual = jugador.getPosicion();

        assertEquals(posicionEsperada, posicionActual);
    }
}
