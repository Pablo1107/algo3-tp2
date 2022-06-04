package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.coordenada.Coordenada;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class MapaTest {
	@Test
	public void dadaUnaCoordenadaCuyasComponentesEstanDentroDeLosLimitesDelMapaEsaPosicionEstaDentroDelMapa() {
		int ancho = 20;
		int alto = 20;
		Mapa mapa = new Mapa(ancho, alto);
		Coordenada coordenadaDentroDelMapa = new Coordenada(10, 10);

		assertTrue(mapa.posicionEstaDentroDeLosLimites(coordenadaDentroDelMapa));
	}

	@Test
	public void dadaUnaCoordenadaCuyasComponentesExcedenLosLimitesDelMapaEsaPosicionEstaDentroDelMapa() {
		int ancho = 20;
		int alto = 20;
		Mapa mapa = new Mapa(ancho, alto);
		Coordenada coordenadaFueraDelMapa1 = new Coordenada(30, 30);

		assertFalse(mapa.posicionEstaDentroDeLosLimites(coordenadaFueraDelMapa1));

		// TODO: Cuando escribi esta linea de codigo pense: Convendria hacer
		// que desde el constructor de Coordenada no podamos tener coordenadas
		// negativas??? Pero no conviene, porque si podriamos tener direcciones
		// negativas, y las direcciones por ahora son Coordenadas, hay que ver
		// si podemos separarlas, no veia demasiadas diferencias como para
		// justificar dos clases casi iguales pero esta si me parece
		// significativa.
		Coordenada coordenadaFueraDelMapa2 = new Coordenada(-10, -10);

		assertFalse(mapa.posicionEstaDentroDeLosLimites(coordenadaFueraDelMapa2));
	}
}
