package edu.fiuba.algo3.modelo.mapa;

public class Direccion {
    private final int x;
    private final int y;

    public Direccion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Posicion desplazar(Posicion posicion, Mapa mapa) {
        Posicion nuevaPosicion = posicion.sumar(this.x, this.y);

        if (!nuevaPosicion.estaDentroDelMapa(mapa)) {
            return posicion;
        }

        return nuevaPosicion;
    }
}

