package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementosYMapaTest {
    @Test
    public void alAgregarNElementosAlMapaLaCantidadDeElementosEsEfectivamenteN() {
        Mapa mapa = new Mapa(10, 10);

        int cantidadElementosEsperada = 10;

        for (int i = 0; i < cantidadElementosEsperada; i++) {
            mapa.agregarElemento(new Pozo(new Posicion(i, i)));
        }

        int cantidadElementosRecibida = mapa.getElementos().size();

        assertEquals(cantidadElementosEsperada, cantidadElementosRecibida);
    }

    @Test
    public void alAgregarElementoAlMapaEstosSePuedenEncontrarEnElMapa() {
        Mapa mapa = new Mapa(10, 10);

        Elemento pozo0 = new Pozo(new Posicion(1, 0));
        Elemento pozo1 = new Pozo(new Posicion(2, 0));
        Elemento pozo2 = new Pozo(new Posicion(3, 0));

        mapa.agregarElemento(pozo0);
        mapa.agregarElemento(pozo1);
        mapa.agregarElemento(pozo2);

        List<Elemento> elementosEnMapa = mapa.getElementos();

        assertTrue(elementosEnMapa.contains(pozo0));
        assertTrue(elementosEnMapa.contains(pozo1));
        assertTrue(elementosEnMapa.contains(pozo2));
    }

}
