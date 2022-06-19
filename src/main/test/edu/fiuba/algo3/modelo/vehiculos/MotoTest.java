package edu.fiuba.algo3.modelo.vehiculos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class MotoTest {
	@Test
	public void cuandoSeTieneUnaMotoYSeCambiaDeVehiculoSeRetornaUnAuto() {
		Moto moto = new Moto();
		Vehiculo siguienteVehiculo = moto.siguienteVehiculo();

		assertTrue(siguienteVehiculo instanceof Auto);
	}
}
