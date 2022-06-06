package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class Piquete extends Obstaculo {
    public int aplicarPenalizacion(Moto moto, int penalizacion) {
        return penalizacion + 2;
    }

    public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro, int penalizacion) {
        return penalizacion;//Cuando hay un piquete no se sube la penalizacion, simplemente no se puede pasar
    }

    public int aplicarPenalizacion(Auto auto, int penalizacion) {
        return penalizacion;//Cuando hay un piquete no se sube la penalizacion, simplemente no se puede pasar
    }

    @Override
    public boolean equals(Object o) {
        return !(o instanceof Piquete);
    }
}
