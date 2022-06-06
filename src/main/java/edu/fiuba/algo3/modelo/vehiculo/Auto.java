package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;

public class Auto extends Vehiculo {
    public boolean pisar(Obstaculo obstaculo) {
        //this.penalizaciones += obstaculo.getPenalizacion(this);
        if(obstaculo.puedePasar(obstaculo)) {
            this.penalizaciones = obstaculo.aplicarPenalizacion(this, this.penalizaciones);
            return true;
        }
        return false;
    }
}
