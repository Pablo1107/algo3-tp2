package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador {
    private Vehiculo vehiculo;
    private Posicion posicion;
    private Posicion posicionAnterior;
    private int movimientos;

    public Jugador(Posicion posicionInicial, Vehiculo vehiculo) {
        this.posicion = posicionInicial;
        this.posicionAnterior = posicionInicial;
        this.vehiculo = vehiculo;
        this.movimientos = 0;
    }

    public void avanzar(Direccion direccion, Mapa mapa) {
        if (this.vehiculo.tienePenalizaciones()) {
            this.vehiculo.reducirPenalizaciones();
            return;
        }

        this.movimientos++;
        this.posicionAnterior = this.posicion;
        this.posicion = direccion.desplazar(posicion, mapa);

        mapa.chocarConElemento(this);
    }

    public void retroceder() {
        this.posicion = this.posicionAnterior;
    }

    public void cambiarVehiculo() {
        this.vehiculo = this.vehiculo.siguienteVehiculo();
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public int getMovimientos() {
        return this.movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }
}
