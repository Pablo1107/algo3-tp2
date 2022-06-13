package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
