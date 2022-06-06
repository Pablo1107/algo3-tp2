package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class Piquete extends Obstaculo {
    public int getPenalizacion(Moto moto) {
        return 2;
    }

    public int getPenalizacion(Auto auto) {
        return 0;//Esto se debe cambiar
    }

    public int getPenalizacion(CuatroXCuatro cuatroXCuatro) {
        return 0;//Esto se debe cambiar
    }
}
