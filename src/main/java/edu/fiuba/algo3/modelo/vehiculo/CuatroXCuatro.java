package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Pozo;

public class CuatroXCuatro extends Vehiculo {
    private int pozosPisados;

    public boolean pisar(Obstaculo obstaculo) {
        //this.penalizaciones += obstaculo.getPenalizacion(this);
        if(obstaculo.puedePasar(obstaculo)) {
            this.penalizaciones = obstaculo.aplicarPenalizacion(this, this.penalizaciones);
            return true;
        }
        return false;
    }

//    public void pisar(Pozo pozo) {
//        this.pozosPisados++;
//        if (this.pozosPisados < 3) return;
//        this.penalizaciones += pozo.getPenalizacion(this);
//        this.pozosPisados = 0;
//    }
}
