package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.mapa.elemento.sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.mapa.elemento.sorpresa.Favorable;

public class Auto extends Vehiculo {
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
