package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ObstaculoNulo extends Obstaculo {
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
