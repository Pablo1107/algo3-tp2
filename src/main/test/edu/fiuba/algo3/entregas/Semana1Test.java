package edu.fiuba.algo3.entregas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Semana1Test {
    @Test
    public void unaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEn3Movientos() {
        Posicion posicionInicial = new Posicion(0, 0);
        Moto moto = new Moto();

        Jugador jugador = new Jugador(posicionInicial, moto);

        Mapa mapa = new Mapa(10, 10);
        Posicion posicionPozo = new Posicion(1, 0);
        Pozo pozo = new Pozo(posicionPozo);

        mapa.agregarElemento(pozo);

        Posicion direccion = new Posicion(1, 0);

        // Se encuentra con el pozo.
        jugador.avanzar(direccion, mapa); // penalizaciones: 3
        assertTrue(moto.tienePenalizaciones());

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
    public void unAutoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadoEnTresMovimientos() {
        Posicion posicionInicial = new Posicion(0, 0);
        Auto auto = new Auto();

        Jugador jugador = new Jugador(posicionInicial, auto);

        Mapa mapa = new Mapa(10, 10);
        Posicion posicionPozo = new Posicion(1, 0);
        Pozo pozo = new Pozo(posicionPozo);

        mapa.agregarElemento(pozo);

        Posicion direccion = new Posicion(1, 0);

        // Se encuentra con el pozo.
        jugador.avanzar(direccion, mapa); // penalizaciones: 3
        assertTrue(auto.tienePenalizaciones());

        jugador.avanzar(direccion, mapa); // penalizaciones: 2
        assertTrue(auto.tienePenalizaciones());

        jugador.avanzar(direccion, mapa); // penalizaciones: 1
        assertTrue(auto.tienePenalizaciones());

        jugador.avanzar(direccion, mapa); // penalizaciones: 0
        assertFalse(auto.tienePenalizaciones());

        jugador.avanzar(direccion, mapa);

        Posicion posicionEsperada = new Posicion(2, 0);
        Posicion posicionActual = jugador.getPosicion();

        assertEquals(posicionEsperada, posicionActual);
    }

    @Test
    public void unCuatroXCuatroAtraviesaLaCiudadYSeEncuentraConUnPozoPorPrimeraYSegundaVezYNoEsPenalizado() {
        Posicion posicionInicial = new Posicion(0, 0);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();

        Jugador jugador = new Jugador(posicionInicial, cuatroXCuatro);

        Mapa mapa = new Mapa(10, 10);

        Posicion posicionPozo1 = new Posicion(1, 0);
        Posicion posicionPozo2 = new Posicion(2, 0);
        Pozo pozo1 = new Pozo(posicionPozo1);
        Pozo pozo2 = new Pozo(posicionPozo2);

        mapa.agregarElemento(pozo1);
        mapa.agregarElemento(pozo2);

        Posicion direccion = new Posicion(1, 0);

        jugador.avanzar(direccion, mapa); // Se encuentra con el primer pozo.
        assertFalse(cuatroXCuatro.tienePenalizaciones());

        jugador.avanzar(direccion, mapa); // Se encuentra con el segundo pozo.
        assertFalse(cuatroXCuatro.tienePenalizaciones());

        Posicion posicionEsperada = new Posicion(2, 0);
        Posicion posicionActual = jugador.getPosicion();

        assertEquals(posicionEsperada, posicionActual);
    }

    @Test
    public void unCuatroXCuatroAtraviesaLaCiudadYSeEncuentraConUnPozoPorTerceraVezYEsPenalizadoEn2Movimientos() {
        Posicion posicionInicial = new Posicion(0, 0);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();

        Jugador jugador = new Jugador(posicionInicial, cuatroXCuatro);

        Mapa mapa = new Mapa(10, 10);

        Posicion posicionPozo1 = new Posicion(1, 0);
        Posicion posicionPozo2 = new Posicion(2, 0);
        Posicion posicionPozo3 = new Posicion(3, 0);
        Pozo pozo1 = new Pozo(posicionPozo1);
        Pozo pozo2 = new Pozo(posicionPozo2);
        Pozo pozo3 = new Pozo(posicionPozo3);

        mapa.agregarElemento(pozo1);
        mapa.agregarElemento(pozo2);
        mapa.agregarElemento(pozo3);

        Posicion direccion = new Posicion(1, 0);

        jugador.avanzar(direccion, mapa); // Se encuentra con el primer pozo, no es penalizado.
        jugador.avanzar(direccion, mapa); // Se encuentra con el segundo pozo, no es penalizado.
        assertFalse(cuatroXCuatro.tienePenalizaciones());

        // Se encuentra con el tercer pozo, es penalizado.
        jugador.avanzar(direccion, mapa); // penalizaciones: 2
        assertTrue(cuatroXCuatro.tienePenalizaciones());

        jugador.avanzar(direccion, mapa); // penalizaciones: 1
        assertTrue(cuatroXCuatro.tienePenalizaciones());

        jugador.avanzar(direccion, mapa); // penalizaciones: 0
        assertFalse(cuatroXCuatro.tienePenalizaciones());

        jugador.avanzar(direccion, mapa);

        Posicion posicionEsperada = new Posicion(4, 0);
        Posicion posicionActual = jugador.getPosicion();

        assertEquals(posicionEsperada, posicionActual);
    }

    // Los casos de uso adicionales para la semana 1 son los encuentros de vehiculos con
    // el control policial. Estos se testean directamente en las pruebas unitarias de ControlPolicial.
}
