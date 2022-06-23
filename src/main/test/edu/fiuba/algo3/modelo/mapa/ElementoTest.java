package edu.fiuba.algo3.modelo.mapa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;

public class ElementoTest {
    @Test
    public void alCrearUnElementoSuPosicionEsLaEsperada() {
        Posicion posicion = new Posicion(1, 10);
        Elemento elemento = new Pozo(posicion);

        Posicion posicionEsperada = posicion;
        Posicion posicionObtenida = elemento.getPosicion();

        assertEquals(posicionEsperada, posicionObtenida);
    }
}
