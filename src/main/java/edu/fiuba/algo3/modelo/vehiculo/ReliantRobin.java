package edu.fiuba.algo3.modelo.vehiculo;

import java.util.Random;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;

public class ReliantRobin extends Vehiculo {
    private static final double PROBABILIDAD_AUTO = 0.6;

    private Auto auto = new Auto();
    private Moto moto = new Moto();
    private Vehiculo vehiculoActual;

    private void pisar(Obstaculo obstaculo) {
        // Joaquin: Vamos a testear esto con printf.
        Random random = new Random();
        if (random.nextDouble() < PROBABILIDAD_AUTO) {
            System.out.println("Auto");
            this.vehiculoActual = this.auto;
            this.auto.pisar(obstaculo);
        } else {
            System.out.println("Moto");
            this.vehiculoActual = this.moto;
            this.moto.pisar(obstaculo);
        }

        this.penalizaciones = this.moto.penalizaciones + this.auto.penalizaciones;
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
        this.vehiculoActual.retroceder(jugador);
    }

    @Override
    public void reducirPenalizaciones() {
        if (this.auto.tienePenalizaciones()) {
            this.auto.reducirPenalizaciones();
        } else if (this.moto.tienePenalizaciones()) {
            this.moto.reducirPenalizaciones();
        }
        this.penalizaciones = this.moto.penalizaciones + this.auto.penalizaciones;
        System.out.println(this.penalizaciones);
    }

    @Override
    public boolean tienePenalizaciones() {
        return this.penalizaciones > 0;
    }
}
