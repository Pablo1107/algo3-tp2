package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ControlPolicial extends Obstaculo {
    public int aplicarPenalizacion(Moto moto, int penalizacion) {
        if(Math.random()<0.8) {
            penalizacion += 3;
        }
        return penalizacion;
    }

    public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro, int penalizacion) {
        if(Math.random()<0.5) {
            penalizacion += 3;
        }
        return penalizacion;
    }

    public int aplicarPenalizacion(Auto auto, int penalizacion) {
        if(Math.random()<0.3) {
            penalizacion += 3;
        }
        return penalizacion;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

}
