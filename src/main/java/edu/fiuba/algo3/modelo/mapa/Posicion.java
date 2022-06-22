package edu.fiuba.algo3.modelo.mapa;

public class Posicion {
    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean estaDentroDelMapa(Mapa mapa) {
        return (0 <= this.x && this.x < mapa.getLimiteX()) && (0 <= this.y && this.y < mapa.getLimiteY());
    }

    public Posicion sumar(int x, int y) {
        return new Posicion(this.x + x, this.y + y);
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

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
