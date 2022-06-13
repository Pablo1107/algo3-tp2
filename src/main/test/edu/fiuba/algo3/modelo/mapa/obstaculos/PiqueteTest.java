package edu.fiuba.algo3.modelo.mapa.obstaculos;

import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiqueteTest {
    @Test
    public void laPenalizacionDeUnPiqueteParaUnaMotoEsDos() {
        Posicion posicion = new Posicion(5, 5);
        Piquete piquete = new Piquete(posicion);
        Moto moto = new Moto();

        int penalizacionEsperada = 2;
        int penalizacionAplicada = piquete.aplicarPenalizacion(moto);

        assertEquals(penalizacionEsperada, penalizacionAplicada);
    }

    @Test
    public void laPenalizacionDeUnPiqueteParaUnAutoEsCero() {
        Posicion posicion = new Posicion(5, 5);
        Piquete piquete = new Piquete(posicion);
        Auto auto = new Auto();

        int penalizacionEsperada = 0;
        int penalizacionAplicada = piquete.aplicarPenalizacion(auto);

        assertEquals(penalizacionEsperada, penalizacionAplicada);
    }

    @Test
    public void laPenalizacionDeUnPiqueteParaUnCuatroXCuatroEsCeroOTres() {
        Posicion posicion = new Posicion(5, 5);
        Piquete piquete = new Piquete(posicion);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();

        int penalizacionEsperada = 0;
        int penalizacionAplicada = piquete.aplicarPenalizacion(cuatroXCuatro);

        assertEquals(penalizacionEsperada, penalizacionAplicada);
    }
}
