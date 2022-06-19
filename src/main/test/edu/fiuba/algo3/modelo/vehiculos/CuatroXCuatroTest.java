package edu.fiuba.algo3.modelo.vehiculos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class CuatroXCuatroTest {
	@Test
	public void cuandoSeTieneUnaCuatroXCuatroYSeCambiaDeVehiculoSeRetornaUnaMoto() {
		CuatroXCuatro cuatroXcuatro = new CuatroXCuatro();
		Vehiculo siguienteVehiculo = cuatroXcuatro.siguienteVehiculo();

		assertTrue(siguienteVehiculo instanceof Moto);
	}
}
