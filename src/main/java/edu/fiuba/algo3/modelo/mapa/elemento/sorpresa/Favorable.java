package edu.fiuba.algo3.modelo.mapa.elemento.sorpresa;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class Favorable extends Sorpresa {
    private static final double PORCENAJE_PREMIO = 0.2;

    public Favorable(Posicion posicion) {
        super(posicion);
    }
    /*@Override
    public void chocarCon(Vehiculo vehiculo) {
        vehiculo.pisar(this);
    }*/

    @Override
    public void chocarCon(Jugador jugador) {
        jugador.premioMovimientos(Favorable.PORCENAJE_PREMIO);
    }

}
