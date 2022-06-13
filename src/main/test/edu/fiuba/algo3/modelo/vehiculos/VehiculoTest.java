package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class VehiculoTest {
    @Test
    public void cuandoUnVehiculoNoTienePenalizacionEstasNoSePuedenSeguirReduciendo() {
        Vehiculo vehiculo = new Moto();

        assertFalse(vehiculo.tienePenalizaciones());

        vehiculo.reducirPenalizaciones();
        vehiculo.reducirPenalizaciones();
        vehiculo.reducirPenalizaciones();

        assertFalse(vehiculo.tienePenalizaciones());
    }
}
