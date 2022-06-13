package edu.fiuba.algo3.modelo.mapa.elemento;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public abstract class Elemento {
    protected Posicion posicion;

    public Elemento(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean estaDentroDelMapa(Mapa mapa) {
        return this.posicion.estaDentroDelMapa(mapa);
    }

    public abstract void chocarCon(Jugador jugador);

    public boolean estaEnLaMismaPosicion(Posicion posicion) {
        return this.posicion.equals(posicion);
    }

    public boolean estaEnLaMismaPosicion(Elemento elemento) {
        return this.posicion.equals(elemento.posicion);
    }
}
