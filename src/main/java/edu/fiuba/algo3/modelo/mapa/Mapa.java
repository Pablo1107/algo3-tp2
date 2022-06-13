package edu.fiuba.algo3.modelo.mapa;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    int limiteX;
    int limiteY;
    List<Elemento> elementos;

    public Mapa(int limiteX, int limiteY) {
        if (limiteX <= 0 || limiteY <= 0) {
            throw new RuntimeException("Dimensiones menores o iguales a cero");
        }

        this.limiteX = limiteX;
        this.limiteY = limiteY;
        this.elementos = new ArrayList<>();
    }

    public void agregarElemento(Elemento elemento) {
        if (!elemento.estaDentroDelMapa(this)) {
            return;
        }

        if (this.hayElementoEnMismaPosicion(elemento)) {
            return;
        }

        this.elementos.add(elemento);
    }

    private boolean hayElementoEnMismaPosicion(Elemento elemento) {
        for (Elemento e : this.elementos) {
            if (e.estaEnLaMismaPosicion(elemento)) {
                return true;
            }
        }
        return false;
    }

    public Elemento obtenerElementoEnPosicion(Posicion posicion) {
        for (Elemento e : this.elementos) {
            if (e.estaEnLaMismaPosicion(posicion)) {
                return e;
            }
        }
        return new ObstaculoNulo(posicion);
    }

    public int getLimiteX() {
        return this.limiteX;
    }

    public int getLimiteY() {
        return this.limiteY;
    }
}
