package edu.fiuba.algo3.modelo.mapa.obstaculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

public class ObstaculoNuloTest {
	@Test
	public void laPenalizacionDeUnObstaculoNuloParaUnaMotoEsCero() {
		ObstaculoNulo obstaculo = new ObstaculoNulo();

		assertEquals(0, obstaculo.aplicarPenalizacion(new Moto()));
	}

	@Test
	public void laPenalizacionDeUnObstaculoNuloParaUnAutoEsCero() {
		ObstaculoNulo obstaculo = new ObstaculoNulo();

		assertEquals(0, obstaculo.aplicarPenalizacion(new Auto()));
	}

	@Test
	public void laPenalizacionDeUnObstaculoNuloParaUnCuatroXCuatroEsCero() {
		ObstaculoNulo obstaculo = new ObstaculoNulo();

		assertEquals(0, obstaculo.aplicarPenalizacion(new CuatroXCuatro()));
	}
}
