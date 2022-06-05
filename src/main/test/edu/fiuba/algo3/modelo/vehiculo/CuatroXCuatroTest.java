package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.ObstaculoNulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuatroXCuatroTest {

    @Test
    public void alPosicionarUnaCuatroXCuatroSobreUnaPosicionVaciaSeRetornaLaPenalizacionCorrespondiente() {
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        int penalizacionInicial = cuatroXCuatro.getPenalizaciones();

        cuatroXCuatro.pisar(new ObstaculoNulo());
        assertEquals(penalizacionInicial, cuatroXCuatro.getPenalizaciones());
    }
}
