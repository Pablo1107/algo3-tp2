package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        Elemento elemento = new ObstaculoNulo(posicion);

        mapa.agregarElemento(elemento);

        Elemento elementoEsperado = elemento;
        Elemento elementoEnPosicion = mapa.obtenerElementoEnPosicion(posicion);

        assertEquals(elementoEsperado, elementoEnPosicion);
    }

    @Test
    public void alIntentarObtenerUnElementoEnUnaPosicionVaciaSeRetornaUnElementoNulo() {
        Mapa mapa = new Mapa(20, 20);
        Posicion posicion = new Posicion(10, 10);

        Elemento elementoEnPosicion = mapa.obtenerElementoEnPosicion(posicion);

        assertEquals(ObstaculoNulo.class, elementoEnPosicion.getClass());
    }

    @Test
    public void noSePuedePosicionarUnElementoFueraDelMapa() {
        Mapa mapa = new Mapa(2, 2);

        Posicion posicionExcedenteEnX = new Posicion(5, 1);
        Elemento elemento = new Pozo(posicionExcedenteEnX);
        mapa.agregarElemento(elemento);

        Elemento elementoEnPosicion = mapa.obtenerElementoEnPosicion(posicionExcedenteEnX);
        assertEquals(ObstaculoNulo.class, elementoEnPosicion.getClass());

        Posicion posicionExcedenteEnY = new Posicion(1, 5);
        elemento = new Pozo(posicionExcedenteEnY);
        mapa.agregarElemento(elemento);

        elementoEnPosicion = mapa.obtenerElementoEnPosicion(posicionExcedenteEnX);
        assertEquals(ObstaculoNulo.class, elementoEnPosicion.getClass());

        Posicion posicionExcedenteEnXeY = new Posicion(5, 5);
        elemento = new Pozo(posicionExcedenteEnXeY);
        mapa.agregarElemento(elemento);

        elementoEnPosicion = mapa.obtenerElementoEnPosicion(posicionExcedenteEnXeY);
        assertEquals(ObstaculoNulo.class, elementoEnPosicion.getClass());
    }

    @Test
    public void noSePuedePosicionarUnElementoEnUnaPosicionQueYaEsteOcupada() {
        Mapa mapa = new Mapa(20, 20);
        Posicion posicion = new Posicion(10, 10);

        Elemento elementoQueYaEstaba = new Pozo(posicion);
        Elemento nuevoElemento = new Pozo(posicion);

        mapa.agregarElemento(elementoQueYaEstaba);
        mapa.agregarElemento(nuevoElemento);

        Elemento elementoEsperado = elementoQueYaEstaba;
        Elemento elementoEnPosicion = mapa.obtenerElementoEnPosicion(posicion);

        assertEquals(elementoEsperado, elementoEnPosicion);
    }

    @Test
    public void alIntentarObtenerUnElementoEnUnaPosicionFueraDelMapaSeRetornaUnElementoNulo() {
        Mapa mapa = new Mapa(10, 10);

        assertEquals(mapa.obtenerElementoEnPosicion(new Posicion(20, 20)).getClass(), ObstaculoNulo.class);
    }

}
