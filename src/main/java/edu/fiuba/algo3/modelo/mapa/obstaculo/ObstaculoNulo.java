package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ObstaculoNulo extends Obstaculo {
    public int getPenalizacion(Moto moto) {
        return 0;
    }

    public int getPenalizacion(Auto auto) {
        return 0;
    }
}
