package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador {
    private final String nombre;
    private Vehiculo vehiculo;
    private Posicion posicion;
    private Posicion posicionAnterior;
    private int movimientos;
    private final Posicion posicionInicial;

    public Jugador(String nombre, Posicion posicionInicial, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.posicionInicial = posicionInicial;
        this.posicion = this.posicionInicial;
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

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public void volverAPosicionInicial() {
        this.posicion = this.posicionInicial;
        this.setMovimientos(0);
    }

    public int getMovimientos() {
        return this.movimientos;
    }

    public String getNombre() {
        return this.nombre;
    }
}
