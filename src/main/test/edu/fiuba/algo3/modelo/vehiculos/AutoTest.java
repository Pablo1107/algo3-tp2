package edu.fiuba.algo3.modelo.vehiculos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class AutoTest {
	@Test
	public void cuandoSeTieneUnaAutoYSeCambiaDeVehiculoSeRetornaUnCuatroXCuatro() {
		Auto auto = new Auto();
		Vehiculo siguienteVehiculo = auto.siguienteVehiculo();

		assertTrue(siguienteVehiculo instanceof CuatroXCuatro);
	}
}
