package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
