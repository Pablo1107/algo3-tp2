package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public abstract class Elemento {
    protected Posicion posicion;

    public Elemento(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void chocarCon(Jugador jugador);

    public boolean estaDentroDelMapa(Mapa mapa) {
        return this.posicion.estaDentroDelMapa(mapa);
    }

    public boolean estaEnLaMismaPosicion(Elemento elemento) {
        return this.posicion.equals(elemento.posicion);
    }

    public boolean estaEnLaMismaPosicion(Posicion posicion) {
        return this.posicion.equals(posicion);
    }
}
