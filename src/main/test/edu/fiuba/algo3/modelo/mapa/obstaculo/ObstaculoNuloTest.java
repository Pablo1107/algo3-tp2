package edu.fiuba.algo3.modelo.mapa.obstaculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ObstaculoNuloTest {
	@Test
	public void laPenalizacionDeUnObstaculoNuloParaUnaMotoEsCero() {
		ObstaculoNulo obstaculo = new ObstaculoNulo();

		assertEquals(0, obstaculo.getPenalizacionMoto());
	}

	@Test
	public void laPenalizacionDeUnObstaculoNuloParaUnAutoEsCero() {
		ObstaculoNulo obstaculo = new ObstaculoNulo();

		assertEquals(0, obstaculo.getPenalizacionAuto());
	}

	@Test
	public void laPenalizacionDeUnObstaculoNuloParaUnCuatroXCuatroEsCero() {
		ObstaculoNulo obstaculo = new ObstaculoNulo();

		assertEquals(0, obstaculo.getPenalizacionCuatroXCuatro());
	}
}
