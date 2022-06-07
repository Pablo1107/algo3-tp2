package edu.fiuba.algo3.modelo.mapa.obstaculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

public class PozoTest {
	@Test
	public void laPenalizacionDeUnPozoParaUnaMotoEsCero() {
		Pozo obstaculo = new Pozo();

		assertEquals(3, obstaculo.aplicarPenalizacion(new Moto()));
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnAutoEsCero() {
		Pozo obstaculo = new Pozo();

		assertEquals(3, obstaculo.aplicarPenalizacion(new Auto()));
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnCuatroXCuatroEsCero() {
		Pozo obstaculo = new Pozo();

		assertEquals(2, obstaculo.aplicarPenalizacion(new CuatroXCuatro()));
	}
}
