package edu.fiuba.algo3.modelo.mapa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;

public class MapaTest {
    @Test
    public void noSePuedeCrearUnMapaConDimensionesNegativas() {
        Exception excepcion = assertThrows(RuntimeException.class, () -> {
            new Mapa(-10, 10);
        });

        String mensajeRecibido = excepcion.getMessage();
        String mensajeEsperado = "Dimensiones menores o iguales a cero";

        assertEquals(mensajeRecibido, mensajeEsperado);

        excepcion = assertThrows(RuntimeException.class, () -> {
            new Mapa(10, -10);
        });

        mensajeRecibido = excepcion.getMessage();
        mensajeEsperado = "Dimensiones menores o iguales a cero";

        assertEquals(mensajeRecibido, mensajeEsperado);
    }

    @Test
    public void noSePuedeCrearUnMapaConDimensionesNulas() {
        Exception excepcion = assertThrows(RuntimeException.class, () -> {
            new Mapa(0, 0);
        });

        String mensajeRecibido = excepcion.getMessage();
        String mensajeEsperado = "Dimensiones menores o iguales a cero";

        assertEquals(mensajeRecibido, mensajeEsperado);
    }

    @Test
    public void sePuedeAgregarUnElementoCorrectamente() {
        Mapa mapa = new Mapa(10, 10);

        Posicion posicion = new Posicion(5, 5);
        Elemento elemento = new ElementoNulo(posicion);

        mapa.agregarElemento(elemento);

        assertEquals(mapa.obtenerElementoEnPosicion(posicion), elemento);
    }

    @Test
    public void noSePuedePosicionarUnElementoFueraDelMapa() {
        Mapa mapa = new Mapa(2, 2);
        Posicion posicion = new Posicion(5, 5);
        Elemento elemento = new Pozo(posicion);

        mapa.agregarElemento(elemento);

        Elemento elementoEnPosicionAgregada = mapa.obtenerElementoEnPosicion(posicion);

        assertEquals(elementoEnPosicionAgregada.getClass(), ElementoNulo.class);
    }

    @Test
    public void noSePuedePosicionarUnElementoEnUnaPosicionQueYaEsteOcupada() {
        Mapa mapa = new Mapa(20, 20);
        Posicion posicion = new Posicion(10, 10);
        Elemento elementoQueYaEstaba = new Pozo(posicion);

        Elemento nuevoElemento = new Pozo(posicion);

        mapa.agregarElemento(elementoQueYaEstaba);
        mapa.agregarElemento(nuevoElemento);

        assertEquals(mapa.obtenerElementoEnPosicion(posicion), elementoQueYaEstaba);
    }

    @Test
    public void alIntentarObtenerUnElementoEnUnaPosicionVaciaSeRetornaUnElementoNulo() {
        Mapa mapa = new Mapa(20, 20);

        assertEquals(mapa.obtenerElementoEnPosicion(new Posicion(10, 10)).getClass(), ElementoNulo.class);
    }

    @Test
    public void alIntentarObtenerUnElementoEnUnaPosicionFueraDelMapaSeRetornaUnElementoNulo() {
        Mapa mapa = new Mapa(10, 10);

        assertEquals(mapa.obtenerElementoEnPosicion(new Posicion(20, 20)).getClass(), ElementoNulo.class);
    }
}
