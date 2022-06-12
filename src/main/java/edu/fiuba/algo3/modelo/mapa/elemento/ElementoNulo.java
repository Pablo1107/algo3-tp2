package edu.fiuba.algo3.modelo.mapa.elemento.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ObstaculoNulo extends Obstaculo {
    public void chocarCon(Vehiculo vehiculo) {
        vehiculo.pisar(this);
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
