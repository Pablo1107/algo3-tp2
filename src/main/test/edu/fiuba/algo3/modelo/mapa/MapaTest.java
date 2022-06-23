package edu.fiuba.algo3.modelo.mapa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapaTest {
    @Test
    public void alCrearUnMapaEsteNoTieneElementos() {
        Mapa mapa = new Mapa(10, 10);

        int cantidadElementosEsperada = 0;
        int cantidadElementosRecibida = mapa.getElementos().size();

        assertEquals(cantidadElementosEsperada, cantidadElementosRecibida);
    }

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
}
