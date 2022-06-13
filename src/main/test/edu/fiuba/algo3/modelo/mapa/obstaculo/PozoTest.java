package edu.fiuba.algo3.modelo.mapa.obstaculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class PozoTest {
	@Test
	public void laPenalizacionDeUnPozoParaUnaMotoEsCero() {
        Posicion posicion = new Posicion(5, 5);
		Pozo pozo = new Pozo(posicion);

		assertEquals(3, pozo.aplicarPenalizacion(new Moto()));
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnAutoEsCero() {
		Posicion posicion = new Posicion(5, 5);
		Pozo pozo = new Pozo(posicion);

		assertEquals(3, pozo.aplicarPenalizacion(new Auto()));
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnCuatroXCuatroEsCero() {
		Posicion posicion = new Posicion(5, 5);
		Pozo pozo = new Pozo(posicion);

		assertEquals(2, pozo.aplicarPenalizacion(new CuatroXCuatro()));
	}
}
