package edu.fiuba.algo3.modelo.mapa.elemento;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ElementoNulo implements IChocable {
    /*public void chocarCon(Vehiculo vehiculo) {
        vehiculo.pisar(this);
    }*/

    @Override
    public void chocarCon(Jugador jugador) {
        return;
    }

    public int aplicarPenalizacion(Moto moto) {
        return 0;
    }

    public int aplicarPenalizacion(Auto auto) {
        return 0;
    }

    public int aplicarPenalizacion(CuatroXCuatro auto) {
        return 0;
    }
}
