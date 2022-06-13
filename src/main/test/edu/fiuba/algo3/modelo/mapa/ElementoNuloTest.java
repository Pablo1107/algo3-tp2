package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementoNuloTest {
    @Test
    public void laPenalizacionDeUnObstaculoNuloParaUnaMotoEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ElementoNulo elementoNulo = new ElementoNulo(posicion);
        Moto moto = new Moto();

        int penalizacionEsperada = 0;
        int penalizacionObtenida = elementoNulo.aplicarPenalizacion(moto);

        assertEquals(penalizacionEsperada, penalizacionObtenida);
    }

    @Test
    public void laPenalizacionDeUnObstaculoNuloParaUnAutoEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ElementoNulo elementoNulo = new ElementoNulo(posicion);
        Auto auto = new Auto();

        int penalizacionEsperada = 0;
        int penalizacionObtenida = elementoNulo.aplicarPenalizacion(auto);

        assertEquals(penalizacionEsperada, penalizacionObtenida);
    }

    @Test
    public void laPenalizacionDeUnObstaculoNuloParaUnCuatroXCuatroEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ElementoNulo elementoNulo = new ElementoNulo(posicion);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();

        int penalizacionEsperada = 0;
        int penalizacionObtenida = elementoNulo.aplicarPenalizacion(cuatroXCuatro);

        assertEquals(penalizacionEsperada, penalizacionObtenida);
    }
}
