package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        Elemento elementoEsperado = elemento;
        Elemento elementoEnPosicion = mapa.obtenerElementoEnPosicion(posicion);

        assertEquals(elementoEsperado, elementoEnPosicion);
    }

    @Test
    public void alIntentarObtenerUnElementoEnUnaPosicionVaciaSeRetornaUnElementoNulo() {
        Mapa mapa = new Mapa(20, 20);
        Posicion posicion = new Posicion(10, 10);

        Elemento elementoEnPosicion = mapa.obtenerElementoEnPosicion(posicion);

        assertEquals(ElementoNulo.class, elementoEnPosicion.getClass());
    }

    @Test
    public void noSePuedePosicionarUnElementoFueraDelMapa() {
        Mapa mapa = new Mapa(2, 2);
        Posicion posicion = new Posicion(5, 5);
        Elemento elemento = new Pozo(posicion);

        mapa.agregarElemento(elemento);

        Elemento elementoEnPosicion = mapa.obtenerElementoEnPosicion(posicion);

        assertEquals(ElementoNulo.class, elementoEnPosicion.getClass());
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

        assertEquals(mapa.obtenerElementoEnPosicion(new Posicion(20, 20)).getClass(), ElementoNulo.class);
    }

}
