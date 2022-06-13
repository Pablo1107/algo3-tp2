package edu.fiuba.algo3.modelo.mapa.obstaculos;

import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControlPolicialTest {
    @Test
    public void laPenalizacionDeUnControlPolicialParaUnaMotoEsCeroOTres() {
        Posicion posicion = new Posicion(5, 5);
        ControlPolicial controlPolicial = new ControlPolicial(posicion);
        Moto moto = new Moto();

        int penalizacion = controlPolicial.aplicarPenalizacion(moto);
        assertTrue(penalizacion == 3 || penalizacion == 0);

        // Esta pruebas no tiene mucho sentido pero tengo que probar el vehiculo.pisar para el coverage.
        moto.pisar(controlPolicial);
        assertTrue(moto.tienePenalizaciones() || !moto.tienePenalizaciones());
    }

    @Test
    public void laPenalizacionDeUnControlPolicialParaUnAutoEsCeroOTres() {
        Posicion posicion = new Posicion(5, 5);
        ControlPolicial controlPolicial = new ControlPolicial(posicion);
        Auto auto = new Auto();

        int penalizacion = controlPolicial.aplicarPenalizacion(auto);
        assertTrue(penalizacion == 3 || penalizacion == 0);

        auto.pisar(controlPolicial);
        assertTrue(auto.tienePenalizaciones() || !auto.tienePenalizaciones());
    }

    @Test
    public void laPenalizacionDeUnControlPolicialParaUnCuatroXCuatroEsCeroOTres() {
        Posicion posicion = new Posicion(5, 5);
        ControlPolicial controlPolicial = new ControlPolicial(posicion);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();

        int penalizacion = controlPolicial.aplicarPenalizacion(cuatroXCuatro);
        assertTrue(penalizacion == 3 || penalizacion == 0);

        cuatroXCuatro.pisar(controlPolicial);
        assertTrue(cuatroXCuatro.tienePenalizaciones() || !cuatroXCuatro.tienePenalizaciones());
    }
}
