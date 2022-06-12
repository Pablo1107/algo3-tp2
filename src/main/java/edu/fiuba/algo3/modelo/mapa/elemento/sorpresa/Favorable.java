package edu.fiuba.algo3.modelo.mapa.elemento.sorpresa;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Favorable extends Sorpresa {
    /*@Override
    public void chocarCon(Vehiculo vehiculo) {
        vehiculo.pisar(this);
    }*/

    @Override
    public void chocarCon(Jugador jugador) {
        jugador.premioMovimientos();
    }

    @Override
    public int aplicarPenalizacion(Moto moto) {
        return 0;
    }

    @Override
    public int aplicarPenalizacion(Auto auto) {
        return 0;
    }

    @Override
    public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro) {
        return 0;
    }
}
