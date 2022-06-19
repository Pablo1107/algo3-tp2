package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;

public class CuatroXCuatro extends Vehiculo {
    private static final int LIMITE_POZOS_PISADOS = 3;
    private int pozosPisados;

    public CuatroXCuatro() {
        this.pozosPisados = 0;
    }

    private void pisar(Obstaculo obstaculo) {
        this.penalizaciones += obstaculo.aplicarPenalizacion(this);
    }

    @Override
    public Vehiculo siguienteVehiculo() {
        return new Moto();
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
        this.pozosPisados++;
        if (!pasoElLimiteDePozosPisados()) {
            return;
        }
        this.pisar((Obstaculo) pozo);
        this.pozosPisados = 0;
    }

    @Override
    public void retroceder(Jugador jugador) {
        jugador.retroceder();
    }

    private boolean pasoElLimiteDePozosPisados() {
        return this.pozosPisados >= CuatroXCuatro.LIMITE_POZOS_PISADOS;
    }
}
