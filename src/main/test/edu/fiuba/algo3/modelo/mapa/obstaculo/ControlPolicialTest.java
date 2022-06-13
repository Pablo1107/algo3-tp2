package edu.fiuba.algo3.modelo.mapa.obstaculo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ControlPolicialTest {
	@Test
	public void laPenalizacionDeUnPozoParaUnaMotoEsCeroOTres() {
        Posicion posicion = new Posicion(5, 5);
		ControlPolicial controlPolicial = new ControlPolicial(posicion);

		int penalizacion = controlPolicial.aplicarPenalizacion(new Moto());
		assertTrue(penalizacion == 3 || penalizacion == 0);
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnAutoEsCeroOTres() {
        Posicion posicion = new Posicion(5, 5);
		ControlPolicial controlPolicial = new ControlPolicial(posicion);

		int penalizacion = controlPolicial.aplicarPenalizacion(new Auto());
		assertTrue(penalizacion == 3 || penalizacion == 0);
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnCuatroXCuatroEsCeroOTres() {
        Posicion posicion = new Posicion(5, 5);
		ControlPolicial controlPolicial = new ControlPolicial(posicion);

		int penalizacion = controlPolicial.aplicarPenalizacion(new CuatroXCuatro());
		assertTrue(penalizacion == 3 || penalizacion == 0);
	}
}
