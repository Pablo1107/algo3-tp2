package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.elemento.ElementoNulo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObstaculoNuloTest {
    @Test
    public void laPenalizacionDeUnObstaculoNuloParaUnaMotoEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ElementoNulo elementoNulo = new ElementoNulo(posicion);

       assertEquals(0, elementoNulo.aplicarPenalizacion(new Moto()));
    }

    @Test
    public void laPenalizacionDeUnObstaculoNuloParaUnAutoEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ElementoNulo elementoNulo = new ElementoNulo(posicion);

       assertEquals(0, elementoNulo.aplicarPenalizacion(new Auto()));
    }

    @Test
    public void laPenalizacionDeUnObstaculoNuloParaUnCuatroXCuatroEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ElementoNulo elementoNulo = new ElementoNulo(posicion);

       assertEquals(0, elementoNulo.aplicarPenalizacion(new CuatroXCuatro()));
    }
}
