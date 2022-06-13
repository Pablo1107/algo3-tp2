package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
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

    public void avanzar(Posicion direccion, Mapa mapa) {
        // TODO: Intentar mover a vehiculo (no es necesario para esta entrega).
        if (this.vehiculo.tienePenalizaciones()) {
            this.vehiculo.reducirPenalizaciones();
            return;
        }

        this.movimientos++;
        this.posicion = posicion.desplazar(direccion, mapa);

        Elemento elemento = mapa.obtenerElementoEnPosicion(posicion);
        elemento.chocarCon(this);
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public int getMovimientos() {
        return this.movimientos;
    }

    public void retroceder() {
        this.posicion = this.posicionAnterior;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
}
