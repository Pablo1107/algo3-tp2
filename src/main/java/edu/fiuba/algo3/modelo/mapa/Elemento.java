package edu.fiuba.algo3.modelo.mapa;

public abstract class Elemento {
    private Posicion posicion;

    public Elemento(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean estaDentroDelMapa(Mapa mapa) {
        return this.posicion.estaDentroDelMapa(mapa);
    }
}
