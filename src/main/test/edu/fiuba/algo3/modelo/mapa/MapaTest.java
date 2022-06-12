package edu.fiuba.algo3.modelo.mapa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.elemento.ElementoNulo;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.Pozo;

public class MapaTest {
	@Test
	public void noSePuedeCrearUnMapaConDimensionesNegativasNiNulas() {
		Exception excepcion = assertThrows(RuntimeException.class, () -> {
			new Mapa(-10, 10);
		});

		String mensajeRecibido = excepcion.getMessage();
		String mensajeEsperado = "No se puede crear un mapa con dimensiones menores o iguales a 0";
		assertEquals(mensajeRecibido, mensajeEsperado);

		excepcion = assertThrows(RuntimeException.class, () -> {
			new Mapa(10, -10);
		});

		mensajeRecibido = excepcion.getMessage();
		mensajeEsperado = "No se puede crear un mapa con dimensiones menores o iguales a 0";
		assertEquals(mensajeRecibido, mensajeEsperado);

		excepcion = assertThrows(RuntimeException.class, () -> {
			new Mapa(-10, -10);
		});

		mensajeRecibido = excepcion.getMessage();
		mensajeEsperado = "No se puede crear un mapa con dimensiones menores o iguales a 0";
		assertEquals(mensajeRecibido, mensajeEsperado);
	}

	@Test
	public void dadaUnaPosicionCuyasCooordenadasEstanDentroDeLosLimitesDelMapaEsaPosicionEstaDentroDelMapa() {
		Mapa mapa = new Mapa(20, 20);
		Posicion posicion = new Posicion(10, 10);

		assertTrue(mapa.posicionEstaDentroDelMapa(posicion));
	}

	@Test
	public void dadaUnaPosicionConComponentesNegativasEsaPosicionNoEstaDentroDelMapa() {
		Mapa mapa = new Mapa(20, 20);

		Posicion posicionNegativaEnX = new Posicion(-10, 10);
		assertFalse(mapa.posicionEstaDentroDelMapa(posicionNegativaEnX));

		Posicion posicionNegativaEnY = new Posicion(10, -10);
		assertFalse(mapa.posicionEstaDentroDelMapa(posicionNegativaEnY));

		Posicion posicionNegativaEnXY = new Posicion(-10, -10);
		assertFalse(mapa.posicionEstaDentroDelMapa(posicionNegativaEnXY));
	}

	@Test
	public void dadaUnaPosicionCuyasComponentesExcedenLosLimitesDelMapaEsaPosicionNoEstaDentroDelMapa() {
		Mapa mapa = new Mapa(20, 20);

		Posicion posicionInvalidaEnX = new Posicion(30, 5);
		assertFalse(mapa.posicionEstaDentroDelMapa(posicionInvalidaEnX));

		Posicion posicionInvalidaEnY = new Posicion(5, 30);
		assertFalse(mapa.posicionEstaDentroDelMapa(posicionInvalidaEnY));

		Posicion posicionInvalidaEnXY = new Posicion(30, 30);
		assertFalse(mapa.posicionEstaDentroDelMapa(posicionInvalidaEnXY));
	}

	@Test
	public void sePuedePosicionarUnElementoEnUnaPosicionVaciaDelMapaCorrectamente() {
        // 		Mapa mapa = new Mapa(20, 20);
        // 		ElementoNulo elemento = new ElementoNulo();
        // 		Posicion posicion = new Posicion(5, 5);
        // 		
        // 		mapa.setElementoEnPosicion(elemento, posicion);
        // 
        // 		assertTrue(mapa.getElementoEnPosicion(posicion) == elemento);
	}

	@Test
	public void noSePuedePosicionarUnElementoFueraDelMapa() {
        // 		Mapa mapa = new Mapa(2, 2);
        // 
        // 		Exception excepcion = assertThrows(RuntimeException.class, () -> {
        // 			mapa.setElementoEnPosicion(new ElementoNulo(), new Posicion(5, 5));
        // 		});
        // 
        // 		String mensajeRecibido = excepcion.getMessage();
        // 		String mensajeEsperado = "No se puede posicionar un elemento fuera del mapa";
        // 
        // 		assertEquals(mensajeRecibido, mensajeEsperado);
	}

	@Test
	public void noSePuedePosicionarUnElementoEnUnaPosicionDelMapaQueYaEsteOcupada() {
        // 		Mapa mapa = new Mapa(20, 20);
        // 		Posicion posicion = new Posicion(10, 10);
        // 		Pozo elemento = new Pozo();
        // 
        // 		mapa.setElementoEnPosicion(elemento, posicion);
        // 
        // 		mapa.setElementoEnPosicion(new ElementoNulo(posicion), posicion);
        // 
        // 		assertTrue(mapa.getElementoEnPosicion(posicion) == elemento);
	}

	@Test
	public void alIntentarObtenerUnElementoEnUnaPosicionVaciaSeRetornaUnObstaculoNulo() {
		Mapa mapa = new Mapa(20, 20);

		assertEquals(mapa.getElementoEnPosicion(new Posicion(10, 10)).getClass(), ElementoNulo.class);
	}

	@Test
	public void alIntentarObtenerUnElementoEnUnaPosicionFueraDelMapaSeRetornaUnObstaculoNull() {
		Mapa mapa = new Mapa(10, 10);

		assertEquals(mapa.getElementoEnPosicion(new Posicion(20, 20)).getClass(), ElementoNulo.class);
	}
}
