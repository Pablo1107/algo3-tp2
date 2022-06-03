package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {
    private int penalizaciones;

    public abstract void pisar(Obstaculo obstaculo);
    public abstract void reducirPena();
    public abstract int getPenalizaciones();
}
