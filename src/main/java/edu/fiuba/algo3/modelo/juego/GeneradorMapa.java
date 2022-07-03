package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.mapa.obstaculos.*;
import edu.fiuba.algo3.modelo.mapa.sorpresas.*;

public class GeneradorMapa {
    private Mapa mapa;
    private Meta meta;

    public GeneradorMapa(int limiteX, int limiteY) {
        this.mapa = new Mapa(limiteX, limiteY);
        this.generarMeta();
        this.popularMapaConElementosAleatorios();
    }

    private void generarMeta() {
        Posicion posicionAleatoriaEnUltimaColumna = this.generarPosicionAleatoriaEnColumna(this.mapa.getLimiteX() - 1);
        this.meta = new Meta(posicionAleatoriaEnUltimaColumna);
        this.mapa.agregarElemento(this.meta);
    }

    private Posicion generarPosicionAleatoriaEnColumna(int numeroColumna) {
        int numeroFilaAleatoria = (int)Math.floor(Math.random() * (this.mapa.getLimiteY() - 1));
        return new Posicion(numeroColumna, numeroFilaAleatoria);
    }

    private void popularMapaConElementosAleatorios() {
        for (int i = 0; i < this.mapa.getLimiteX(); i++) {
            for (int j = 0; j < this.mapa.getLimiteY(); j++) {
                Posicion posicion = new Posicion(i, j);
                this.mapa.agregarElemento(this.generarElementoRandom(posicion));
            }
        }
    }

    private Elemento generarElementoRandom(Posicion posicion) {
        double probabilidadGeneracion = Math.random();

        if (probabilidadGeneracion < 0.1) {
            return new Pozo(posicion);
        }

        if (probabilidadGeneracion < 0.2) {
            return new Piquete(posicion);
        }

        if (probabilidadGeneracion < 0.3) {
            return new ControlPolicial(posicion);
        }

        if (probabilidadGeneracion < 0.33) {
            return new Favorable(posicion);
        }

        if (probabilidadGeneracion < 0.36) {
            return new Desfavorable(posicion);
        }

        if (probabilidadGeneracion < 0.4) {
            return new CambioDeVehiculo(posicion);
        }

        return new ElementoNulo(posicion);
    }

    public Mapa getMapa() {
        return this.mapa;
    }

    public Meta getMeta() {
        return this.meta;
    }
}
