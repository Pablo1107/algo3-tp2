package edu.fiuba.algo3.entregas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Favorable;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Semana2Test {
    @Test
    public void unVehiculoAtraviesaLaCiudadYSeEncuentraUnaSorpresaFavorable() {
        Posicion posicionInicial = new Posicion(0, 0);
        Vehiculo vehiculo = new Moto();

        Mapa mapa = new Mapa(10, 10);
        // El jugador va a tener que avanzar 5 veces para llegar a la sorpresa.
        Posicion posicionSorpresa = new Posicion(5, 0);
        Favorable sorpresa = new Favorable(posicionSorpresa);

        mapa.agregarElemento(sorpresa);

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Posicion direccion = new Posicion(1, 0);
        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa); // Llega a la sorpresa.

        int movimientosEsperados = 4;
        int movimientosActuales = jugador.getMovimientos();

        assertEquals(movimientosEsperados, movimientosActuales);
    }

    @Test
    public void unVehiculoAtraviesaLaCiudadYSeEncuentraUnaSorpresaDesfavorable() {
        Posicion posicionInicial = new Posicion(0, 0);
        Vehiculo vehiculo = new Moto();

        Mapa mapa = new Mapa(10, 10);
        // El jugador va a tener que avanzar 4 veces para llegar a la sorpresa.
        Posicion posicionSorpresa = new Posicion(4, 0);
        Desfavorable sorpresa = new Desfavorable(posicionSorpresa);

        mapa.agregarElemento(sorpresa);

        Jugador jugador = new Jugador(posicionInicial, vehiculo);

        Posicion direccion = new Posicion(1, 0);
        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa); // Llega a la sorpresa.

        int movimientosEsperados = 5;
        int movimientosActuales = jugador.getMovimientos();

        assertEquals(movimientosEsperados, movimientosActuales);
    }

    @Test
    public void unVehiculoAtraviesaLaciudadYSeEncuentraUnaSorpresaCambioDeVehiculo() {
        // TODO: ...
    }

    @Test
    public void unaMotoAtraviesaLaCiudadYSeEncuentraConUnPiquetePuedePasarConUnaPenalizacionDe2Movimientos() {
        Posicion posicionInicial = new Posicion(0, 0);
        Moto moto = new Moto();
        Jugador jugador = new Jugador(posicionInicial, moto);

        Posicion posicionPiquete = new Posicion(1, 0);
        Piquete piquete = new Piquete(posicionPiquete);
        Mapa mapa = new Mapa(10, 10);

        mapa.agregarElemento(piquete);

        Posicion direccion = new Posicion(1, 0);

        // Se encuentra con el piquete.
        jugador.avanzar(direccion, mapa); // penalizaciones: 2
        assertTrue(moto.tienePenalizaciones());

        jugador.avanzar(direccion, mapa); // penalizaciones: 1
        assertTrue(moto.tienePenalizaciones());

        jugador.avanzar(direccion, mapa); // penalizaciones: 0
        assertFalse(moto.tienePenalizaciones());

        jugador.avanzar(direccion, mapa);

        Posicion posicionEsperada = new Posicion(2, 0);
        Posicion posicionActual = jugador.getPosicion();

        assertEquals(posicionEsperada, posicionActual);
    }

    @Test
    public void unAutoAtraviesaLaCiudadYSeEncuentraConUnPiqueteNoPuedePasarYDaLaVuelta() {
        Posicion posicionInicial = new Posicion(0, 0);
        Auto auto = new Auto();
        Jugador jugador = new Jugador(posicionInicial, auto);

        Posicion posicionPiquete = new Posicion(2, 0);
        Piquete piquete = new Piquete(posicionPiquete);
        Mapa mapa = new Mapa(10, 10);

        mapa.agregarElemento(piquete);

        Posicion direccion = new Posicion(1, 0);

        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa); // Se encuentra con el piquete.

        assertFalse(auto.tienePenalizaciones());

        Posicion posicionEsperada = new Posicion(1, 0);
        Posicion posicionActual = jugador.getPosicion();

        System.out.println(posicionActual);

        assertEquals(posicionEsperada, posicionActual);
    }

    @Test
    public void unCuatroXCuatroAtraviesaLaCiudadYSeEncuentraConUnPiqueteNoPuedePasarYDaLaVuelta() {
        Posicion posicionInicial = new Posicion(0, 0);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        Jugador jugador = new Jugador(posicionInicial, cuatroXCuatro);

        Posicion posicionPiquete = new Posicion(2, 0);
        Piquete piquete = new Piquete(posicionPiquete);
        Mapa mapa = new Mapa(10, 10);

        mapa.agregarElemento(piquete);

        Posicion direccion = new Posicion(1, 0);

        jugador.avanzar(direccion, mapa);
        jugador.avanzar(direccion, mapa); // Se encuentra con el piquete.

        assertFalse(cuatroXCuatro.tienePenalizaciones());

        Posicion posicionEsperada = new Posicion(1, 0);
        Posicion posicionActual = jugador.getPosicion();

        System.out.println(posicionActual);

        assertEquals(posicionEsperada, posicionActual);
    }
}
