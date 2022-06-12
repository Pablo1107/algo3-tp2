package edu.fiuba.algo3.modelo.mapa.elemento.sorpresa;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Desfavorable extends Sorpresa {
    private static final double PORCENAJE_CASTIGO = 0.25;
    public Desfavorable(Posicion posicion) {
        super(posicion);
    }
    /*@Override
    public void chocarCon(Vehiculo vehiculo) {
        vehiculo.pisar(this);
    }*/

    @Override
    public void chocarCon(Jugador jugador) {
        jugador.castigoMovimientos(Desfavorable.PORCENAJE_CASTIGO);
    }
}
