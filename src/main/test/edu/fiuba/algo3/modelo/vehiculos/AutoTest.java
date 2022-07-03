package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoTest {
    @Test
    public void cuandoSeTieneUnaAutoYSeCambiaDeVehiculoSeRetornaUnCuatroXCuatro() {
        Auto auto = new Auto();
        Vehiculo siguienteVehiculo = auto.siguienteVehiculo();

        assertTrue(siguienteVehiculo instanceof CuatroXCuatro);
    }
}
