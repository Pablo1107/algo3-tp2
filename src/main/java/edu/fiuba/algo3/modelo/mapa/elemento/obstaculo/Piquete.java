package edu.fiuba.algo3.modelo.mapa.elemento.obstaculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class Piquete extends Obstaculo {
    private final static int PENALIZACION_MOTO = 2;
    private final static int PENALIZACION_AUTO = 0;
    private final static int PENALIZACION_CUATROXCUATRO = 0;

    public Piquete(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void chocarCon(Jugador jugador) {
        jugador.getVehiculo().pisar(this);
        jugador.getVehiculo().retroceder(jugador);
    }

    public int aplicarPenalizacion(Moto moto) {
        return Piquete.PENALIZACION_MOTO;
    }

    public int aplicarPenalizacion(Auto auto) {
        return Piquete.PENALIZACION_AUTO;
    }

    public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro) {
        return Piquete.PENALIZACION_CUATROXCUATRO;
    }

}
