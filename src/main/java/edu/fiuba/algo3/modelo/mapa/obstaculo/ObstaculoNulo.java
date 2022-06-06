package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ObstaculoNulo extends Obstaculo {
    public int aplicarPenalizacion(Moto moto, int penalizaciones) {
        return penalizaciones;
    }

    public int aplicarPenalizacion(CuatroXCuatro cuatroxcuatro, int penalizaciones) {
        return penalizaciones;
    }

    public int aplicarPenalizacion(Auto auto, int penalizaciones) {
        return penalizaciones;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }
}
