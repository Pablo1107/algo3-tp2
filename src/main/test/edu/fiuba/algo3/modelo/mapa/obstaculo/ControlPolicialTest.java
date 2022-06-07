package edu.fiuba.algo3.modelo.mapa.obstaculo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ControlPolicialTest {
	@Test
	public void laPenalizacionDeUnPozoParaUnaMotoEsCeroOTres() {
		ControlPolicial controlPolicial = new ControlPolicial();

		int penalizacion = controlPolicial.aplicarPenalizacion(new Moto());
		assertTrue(penalizacion == 3 || penalizacion == 0);
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnAutoEsCeroOTres() {
		ControlPolicial controlPolicial = new ControlPolicial();

		int penalizacion = controlPolicial.aplicarPenalizacion(new Auto());
		assertTrue(penalizacion == 3 || penalizacion == 0);
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnCuatroXCuatroEsCeroOTres() {
		ControlPolicial controlPolicial = new ControlPolicial();

		int penalizacion = controlPolicial.aplicarPenalizacion(new CuatroXCuatro());
		assertTrue(penalizacion == 3 || penalizacion == 0);
	}
}
