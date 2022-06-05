package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.ObstaculoNulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoTest {
    @Test
    public void alPosicionarUnaAutoSobreUnaPosicionVaciaSeRetornaLaPenalizacionCorrespondiente() {
        Auto auto = new Auto();
        int penalizacionInicial = auto.getPenalizaciones();

        auto.pisar(new ObstaculoNulo());
        assertEquals(penalizacionInicial, auto.getPenalizaciones());
    }
}
