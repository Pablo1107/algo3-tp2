package edu.fiuba.algo3.modelo.mapa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PosicionTest {
    @Test
    public void alCrearUnaPosicionSeCreaConLasCoordenadasCorrectas() {
        int coordenadaX = 10;
        int coordenadaY = 10;

        Posicion posicion = new Posicion(coordenadaX, coordenadaY);

        assertEquals(coordenadaX, posicion.getX());
        assertEquals(coordenadaY, posicion.getY());
    }

    @Test
    public void dadasUnaPosicionYUnasCoordenadasSeLesPuedenSumarALaPosicion() {
        Posicion posicion = new Posicion(0, 0);

        Posicion posicionEsperada = new Posicion(10, 10);
        Posicion posicionRecibida = posicion.sumar(10, 10);

        assertEquals(posicionEsperada, posicionRecibida);
    }

    @Test
    public void dadasDosPosicionesEstasSonComparablesEntreSi() {
        Posicion posicion1 = new Posicion(10, 10);
        Posicion posicion2 = new Posicion(10, 10);
        assertEquals(posicion1, posicion2);

        posicion1 = new Posicion(10, 5);
        posicion2 = new Posicion(4, 12);
        assertNotEquals(posicion1, posicion2);

        posicion1 = new Posicion(4, 5);
        posicion2 = new Posicion(4, 12);
        assertNotEquals(posicion1, posicion2);
    }

    @Test
    public void dadaUnaPosicionYOtroObjetoCualqueiraNoSonComparablesEntreSi() {
        Posicion posicion = new Posicion(10, 10);
        Mapa otroObjeto = new Mapa(5, 5);

        assertNotEquals(posicion, otroObjeto);
    }
}
