package edu.fiuba.algo3.modelo.mapa;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;

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

    public void chocarConElemento(Jugador jugador) {
        Posicion posicion = jugador.getPosicion();
        for (Elemento e : this.elementos) {
            if (e.estaEnLaMismaPosicion(posicion)) {
                e.chocarCon(jugador);
            }
        }
    }

    public int getLimiteX() {
        return this.limiteX;
    }

    public int getLimiteY() {
        return this.limiteY;
    }
}
