package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.coordenada.Posicion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Elemento;

public class MapaTest {
	@Test
	public void dadaUnaPosicionCuyasCooordenadasEstanDentroDeLosLimitesDelMapaEsaPosicionEstaDentroDelMapa() {
		Mapa mapa = new Mapa(20, 20);
		Posicion posicion = new Posicion(10, 10);

		assertTrue(mapa.posicionEstaDentroDelMapa(posicion));
	}

	@Test
	public void dadaUnaCoordenadaCuyasComponentesExcedenLosLimitesDelMapaEsaPosicionEstaDentroDelMapa() {
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
		Mapa mapa = new Mapa(20, 20);
		Elemento elemento = new Elemento();
		Posicion posicion = new Posicion(5, 5);
		
		mapa.setElementoEnPosicion(elemento, posicion);

		assertTrue(mapa.getElementoEnPosicion(posicion) == elemento);
	}

	@Test
	public void noSePuedePosicionarUnElementoEnUnaPosicionDelMapaQueYaEsteOcupada() {
		Mapa mapa = new Mapa(20, 20);
		Posicion posicion = new Posicion(10, 10);
		Elemento elemento = new Elemento();

		mapa.setElementoEnPosicion(elemento, posicion);

		mapa.setElementoEnPosicion(new Elemento(), posicion);

		assertTrue(mapa.getElementoEnPosicion(posicion) == elemento);
	}

	@Test
	public void alIntentarObtenerUnElementoEnUnaPosicionVaciaSeRetornaNull() {
		Mapa mapa = new Mapa(20, 20);

		assertTrue(mapa.getElementoEnPosicion(new Posicion(10, 10)) == null);
	}

	@Test
	public void alIntentarObtenerUnElementoEnUnaPosicionFueraDelMapaSeRetornaNull() {
		Mapa mapa = new Mapa(10, 10);

		assertTrue(mapa.getElementoEnPosicion(new Posicion(20, 20)) == null);
	}
}
