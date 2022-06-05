package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;

public class Auto extends Vehiculo {
    public void pisar(Obstaculo obstaculo) {
        this.penalizaciones += obstaculo.getPenalizacion(this);
    }
}
