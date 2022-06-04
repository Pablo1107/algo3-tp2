package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.coordenada.Posicion;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class MapaTest {
	@Test
	public void dadaUnaPosicionCuyasCooordenadasEstanDentroDeLosLimitesDelMapaEsaPosicionEstaDentroDelMapa() {
		int ancho = 20;
		int alto = 20;
		Mapa mapa = new Mapa(ancho, alto);
		Posicion posicion = new Posicion(10, 10);

		assertTrue(mapa.validar(posicion));
	}

	@Test
	public void dadaUnaCoordenadaCuyasComponentesExcedenLosLimitesDelMapaEsaPosicionEstaDentroDelMapa() {
		int ancho = 20;
		int alto = 20;
		Mapa mapa = new Mapa(ancho, alto);
		Posicion posicion = new Posicion(30, 30);

		assertFalse(mapa.validar(posicion));
	}
}
