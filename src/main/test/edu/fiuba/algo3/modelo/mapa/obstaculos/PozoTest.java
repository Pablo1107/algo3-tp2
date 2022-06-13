package edu.fiuba.algo3.modelo.mapa.obstaculos;

import edu.fiuba.algo3.modelo.mapa.Posicion;
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
        Moto moto = new Moto();

        int penalizacionEsperada = 3;
        int penalizacionObtenida = pozo.aplicarPenalizacion(moto);

        assertEquals(penalizacionEsperada, penalizacionObtenida);
    }

    @Test
    public void laPenalizacionDeUnPozoParaUnAutoEsCero() {
        Posicion posicion = new Posicion(5, 5);
        Pozo pozo = new Pozo(posicion);
        Auto auto = new Auto();

        assertEquals(3, pozo.aplicarPenalizacion(auto));
    }

    @Test
    public void laPenalizacionDeUnPozoParaUnCuatroXCuatroEsCero() {
        Posicion posicion = new Posicion(5, 5);
        Pozo pozo = new Pozo(posicion);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();

        assertEquals(2, pozo.aplicarPenalizacion(cuatroXCuatro));
    }
}
