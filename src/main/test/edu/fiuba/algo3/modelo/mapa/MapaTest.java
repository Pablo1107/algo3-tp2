package edu.fiuba.algo3.modelo.mapa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        String mensajeEsperado = "Dimensiones menores o iguales a cero";
        String mensajeRecibido = excepcion.getMessage();

        assertEquals(mensajeEsperado, mensajeRecibido);

        excepcion = assertThrows(RuntimeException.class, () -> {
            new Mapa(10, -10);
        });

        mensajeEsperado = "Dimensiones menores o iguales a cero";
        mensajeRecibido = excepcion.getMessage();

        assertEquals(mensajeEsperado, mensajeRecibido);
    }

    @Test
    public void noSePuedeCrearUnMapaConDimensionesNulas() {
        Exception excepcion = assertThrows(RuntimeException.class, () -> {
            new Mapa(0, 0);
        });

        String mensajeRecibido = excepcion.getMessage();
        String mensajeEsperado = "Dimensiones menores o iguales a cero";

        assertEquals(mensajeEsperado, mensajeRecibido);
    }

    @Test
    public void dadasDosCoordenadasSePuedeSaberSiEstasEstanDentroOFueraDeLosLimitesDelMapa() {
        Mapa mapa = new Mapa(10, 10);

        assertTrue(mapa.estaDentroDeLimites(0, 0));
        assertTrue(mapa.estaDentroDeLimites(5, 5));
        assertFalse(mapa.estaDentroDeLimites(0, 10));
        assertFalse(mapa.estaDentroDeLimites(10, 0));
        assertFalse(mapa.estaDentroDeLimites(10, 10));
    }

    @Test
    public void alCrearUnMapaLosLimitesSonLosCorrectos() {
        Mapa mapa = new Mapa(10, 10);

        int limiteXEsperado = 10;
        int limiteXObtenido = mapa.getLimiteX();

        assertEquals(limiteXEsperado, limiteXObtenido);

        int limiteYEsperado = 10;
        int limiteYObtenido = mapa.getLimiteY();

        assertEquals(limiteYEsperado, limiteYObtenido);
    }
}
