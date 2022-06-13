package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.elemento.Elemento;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador {
    private Posicion posicion;
    private Posicion posicionAnterior;
    private Vehiculo vehiculo;
    private int movimientos;

    public Jugador(Posicion posicionInicial, Vehiculo vehiculo) {
        this.posicion = posicionInicial;
        this.posicionAnterior = posicionInicial;
        this.vehiculo = vehiculo;
        this.movimientos = 0;
    }

    public void mover(Posicion direccion, Mapa mapa) {
        if (this.vehiculo.tienePenalizaciones()) {
            this.vehiculo.reducirPenalizaciones();
            return;
        }

        Posicion nuevaPosicion = posicion.desplazar(direccion, mapa);

        this.movimientos++;
        this.posicion = nuevaPosicion;

        Elemento elemento = mapa.obtenerElementoEnPosicion(posicion);
        elemento.chocarCon(this);
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void retroceder() {
        this.posicion = this.posicionAnterior;
    }

    public int getMovimientos() {
        return this.movimientos;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void premioMovimientos(double porcentajePremio) {
        this.movimientos = (int) (this.movimientos - this.movimientos * porcentajePremio);
    }

    public void castigoMovimientos(double porcentajeCastigo) {
        this.movimientos = (int) (this.movimientos + this.movimientos * porcentajeCastigo);
    }
}
