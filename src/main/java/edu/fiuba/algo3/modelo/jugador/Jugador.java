package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
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

    public void avanzar(Posicion direccion, Mapa mapa) {
        if (this.vehiculo.tienePenalizaciones()) {
            this.vehiculo.reducirPenalizaciones();
            return;
        }

        this.movimientos++;
        this.posicionAnterior = this.posicion;
        this.posicion = posicion.desplazar(direccion, mapa);

//        Elemento elemento = mapa.obtenerElementoEnPosicion(posicion);
//        elemento.chocarCon(this);
        mapa.chocarConElemento(this, this.posicion);
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public int getMovimientos() {
        return this.movimientos;
    }

    // PREGUNTA: Getters de movimento. Ref.: Favorable.java
    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public void retroceder() {
        this.posicion = this.posicionAnterior;
    }

    public void cambiarVehiculo() {
        this.vehiculo.cambio();
    }
}
