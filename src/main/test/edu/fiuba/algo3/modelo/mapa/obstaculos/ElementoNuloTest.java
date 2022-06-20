package edu.fiuba.algo3.modelo.mapa.obstaculos;

import edu.fiuba.algo3.modelo.mapa.ObstaculoNulo;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObstaculoNuloTest {
    @Test
    public void laPenalizacionDeUnObstaculoNuloParaUnaMotoEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ObstaculoNulo obstaculoNulo = new ObstaculoNulo(posicion);
        Moto moto = new Moto();

        int penalizacionEsperada = 0;
        int penalizacionObtenida = obstaculoNulo.aplicarPenalizacion(moto);

        assertEquals(penalizacionEsperada, penalizacionObtenida);
    }

    @Test
    public void laPenalizacionDeUnObstaculoNuloParaUnAutoEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ObstaculoNulo obstaculoNulo = new ObstaculoNulo(posicion);
        Auto auto = new Auto();

        int penalizacionEsperada = 0;
        int penalizacionObtenida = obstaculoNulo.aplicarPenalizacion(auto);

        assertEquals(penalizacionEsperada, penalizacionObtenida);
    }

    @Test
    public void laPenalizacionDeUnObstaculoNuloParaUnCuatroXCuatroEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ObstaculoNulo obstaculoNulo = new ObstaculoNulo(posicion);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();

        int penalizacionEsperada = 0;
        int penalizacionObtenida = obstaculoNulo.aplicarPenalizacion(cuatroXCuatro);

        assertEquals(penalizacionEsperada, penalizacionObtenida);
    }
}
