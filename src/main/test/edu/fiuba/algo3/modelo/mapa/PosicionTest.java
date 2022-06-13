package edu.fiuba.algo3.modelo.mapa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PosicionTest {
    @Test
    public void alDesplazarUnaPosicionEnUnaDireccionDadaSeLlegaALaPosicionEsperada() {
        Posicion posicionInicial = new Posicion(10, 10);
        Posicion direccion = new Posicion(5, 7);

        Mapa mapa = new Mapa(20, 20);

        Posicion posicionEsperada = new Posicion(15, 17);
        Posicion posicionLlegada = posicionInicial.desplazar(direccion, mapa);

        assertEquals(posicionLlegada, posicionEsperada);
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
        Direccion direccion = new Direccion(10, 10);

        assertNotEquals(posicion, direccion);
    }

}
