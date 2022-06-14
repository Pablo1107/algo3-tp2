package edu.fiuba.algo3.modelo.mapa;

public class Posicion {
    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Posicion desplazar(Posicion direccion, Mapa mapa) {
        Posicion nuevaPosicion = new Posicion(this.x + direccion.x, this.y + direccion.y);

        if (!nuevaPosicion.estaDentroDelMapa(mapa)) {
            return this;
        }

        return nuevaPosicion;
    }

    public boolean estaDentroDelMapa(Mapa mapa) {
        return (0 <= this.x && this.x < mapa.getLimiteX()) && (0 <= this.y && this.y < mapa.getLimiteY());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Posicion)) {
            return false;
        }

        Posicion posicion = (Posicion) o;
        return x == posicion.x && y == posicion.y;
    }
}
