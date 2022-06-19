package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;

public class Moto extends Vehiculo {
    private void pisar(Obstaculo obstaculo) {
        this.penalizaciones += obstaculo.aplicarPenalizacion(this);
    }

    @Override
    public Vehiculo siguienteVehiculo() {
        return new Auto();
    }

    @Override
    public void pisar(ControlPolicial controlPolicial) {
        this.pisar((Obstaculo) controlPolicial);
    }

    @Override
    public void pisar(Piquete piquete) {
        this.pisar((Obstaculo) piquete);
    }

    @Override
    public void pisar(Pozo pozo) {
        this.pisar((Obstaculo) pozo);
    }

    @Override
    public void retroceder(Jugador jugador) {
        return;
    }
}
