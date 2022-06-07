package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Pozo;

public class Moto extends Vehiculo {
    private void pisar(Obstaculo obstaculo) {
        this.penalizaciones += obstaculo.aplicarPenalizacion(this);
    }
    public void pisar(Pozo pozo) {
        this.pisar((Obstaculo)pozo);
    }
    public void pisar(ControlPolicial controlPolicial) {
        this.pisar((Obstaculo)controlPolicial);
    }
}
