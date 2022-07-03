package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuatroXCuatroTest {
    @Test
    public void cuandoSeTieneUnaCuatroXCuatroYSeCambiaDeVehiculoSeRetornaUnaMoto() {
        CuatroXCuatro cuatroXcuatro = new CuatroXCuatro();
        Vehiculo siguienteVehiculo = cuatroXcuatro.siguienteVehiculo();

        assertTrue(siguienteVehiculo instanceof Moto);
    }
}
