package edu.fiuba.algo3.modelo.mapa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DireccionTest {
    @Test
    public void alDesplazarUnaPosicionEnUnaDireccionDadaSeLlegaALaPosicionEsperada() {
        Posicion posicion = new Posicion(10, 10);
        Direccion direccion = new Direccion(5, 7);

        Mapa mapa = new Mapa(20, 20);

        Posicion posicionEsperada = new Posicion(15, 17);
        Posicion posicionActual = direccion.desplazar(posicion, mapa);

        assertEquals(posicionEsperada, posicionActual);
    }
}
