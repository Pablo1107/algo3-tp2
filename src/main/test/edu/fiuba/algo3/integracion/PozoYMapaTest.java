package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PozoYMapaTest {
    @Test
    public void dadaUnaPosicionCuyasCooordenadasEstanDentroDeLosLimitesDelMapaEsaPosicionEstaDentroDelMapa() {
        Mapa mapa = new Mapa(20, 20);
        Posicion posicion = new Posicion(10, 10);

        assertTrue(posicion.estaDentroDelMapa(mapa));
    }

    @Test
    public void dadaUnaPosicionConComponentesNegativasEsaPosicionNoEstaDentroDelMapa() {
        Mapa mapa = new Mapa(20, 20);

        Posicion posicionNegativaEnX = new Posicion(-10, 10);
        assertFalse(posicionNegativaEnX.estaDentroDelMapa(mapa));

        Posicion posicionNegativaEnY = new Posicion(10, -10);
        assertFalse(posicionNegativaEnY.estaDentroDelMapa(mapa));

        Posicion posicionNegativaEnXY = new Posicion(-10, -10);
        assertFalse(posicionNegativaEnXY.estaDentroDelMapa(mapa));
    }

    @Test
    public void dadaUnaPosicionCuyasComponentesExcedenLosLimitesDelMapaEsaPosicionNoEstaDentroDelMapa() {
        Mapa mapa = new Mapa(20, 20);

        Posicion posicionFueraDelMapaEnX = new Posicion(30, 5);
        assertFalse(posicionFueraDelMapaEnX.estaDentroDelMapa(mapa));

        Posicion posicionFueraDelMapaEnY = new Posicion(5, 30);
        assertFalse(posicionFueraDelMapaEnY.estaDentroDelMapa(mapa));

        Posicion posicionFueraDelMapaEnXY = new Posicion(30, 30);
        assertFalse(posicionFueraDelMapaEnXY.estaDentroDelMapa(mapa));
    }
}
