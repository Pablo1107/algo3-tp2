package edu.fiuba.algo3.modelo;

public class Auto extends Vehiculo {
    private int penalizaciones;

    public Auto() {
        this.penalizaciones = 0;
    }

    public void pisar(Obstaculo obstaculo) {
        if (obstaculo == null) return;

        this.penalizaciones += obstaculo.penalidad(this);
    }

    public void reducirPena() {
        this.penalizaciones--;
    }

    public int getPenalizaciones() {
        return this.penalizaciones;
    }
}
