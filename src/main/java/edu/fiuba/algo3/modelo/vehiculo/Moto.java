package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.Pozo;

public class Moto extends Vehiculo {
    private void pisar(Obstaculo obstaculo) {
        this.penalizaciones += obstaculo.aplicarPenalizacion(this);
    }

    public void pisar(Pozo pozo) {
        this.pisar((Obstaculo) pozo);
    }

    @Override
    public void pisar(Piquete piquete) {
        this.pisar((Obstaculo) piquete);
    }

    public void pisar(ControlPolicial controlPolicial) {
        this.pisar((Obstaculo) controlPolicial);
    }

    @Override
    public void retroceder(Jugador jugador) {
        return;
    }
}
