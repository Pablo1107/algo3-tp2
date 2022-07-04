package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.mapa.obstaculos.*;
import edu.fiuba.algo3.modelo.mapa.sorpresas.*;

public class GeneradorMapa {
    private static final double PROBABILIDAD_GENERACION_POZO = 0.1;
    private static final double PROBABILIDAD_GENERACION_PIQUETE = 0.2;
    private static final double PROBABILIDAD_GENERACION_CONTROL_POLICIAL = 0.3;
    private static final double PROBABILIDAD_GENERACION_SORPRESA_FAVORABLE = 0.33;
    private static final double PROBABILIDAD_GENERACION_SORPRESA_DESFAVORABLE = 0.36;
    private static final double PROBABILIDAD_GENERACION_SORPRESA_CAMBIO_DE_VEHICULO = 0.4;

    private final Mapa mapa;
    private Meta meta;

    public GeneradorMapa(int limiteX, int limiteY, Posicion posicionInicialJugador) {
        this.mapa = new Mapa(limiteX, limiteY);
        this.generarMeta();
        this.popularMapaConElementosAleatorios(posicionInicialJugador);
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

    private void popularMapaConElementosAleatorios(Posicion posicionInicialJugador) {
        this.generarEspacioLibreInicialParaJugador(posicionInicialJugador);
        for (int i = 0; i < this.mapa.getLimiteX(); i++) {
            for (int j = 0; j < this.mapa.getLimiteY(); j++) {
                Posicion posicion = new Posicion(i, j);
                this.mapa.agregarElemento(this.generarElementoRandom(posicion));
            }
        }
    }

    private void generarEspacioLibreInicialParaJugador(Posicion posicionInicialJugador) {
        this.mapa.agregarElemento(new ElementoNulo(posicionInicialJugador));
    }

    private Elemento generarElementoRandom(Posicion posicion) {
        double probabilidadGeneracion = Math.random();

        if (probabilidadGeneracion < PROBABILIDAD_GENERACION_POZO) {
            return new Pozo(posicion);
        }

        if (probabilidadGeneracion < PROBABILIDAD_GENERACION_PIQUETE) {
            return new Piquete(posicion);
        }

        if (probabilidadGeneracion < PROBABILIDAD_GENERACION_CONTROL_POLICIAL) {
            return new ControlPolicial(posicion);
        }

        if (probabilidadGeneracion < PROBABILIDAD_GENERACION_SORPRESA_FAVORABLE) {
            return new Favorable(posicion);
        }

        if (probabilidadGeneracion < PROBABILIDAD_GENERACION_SORPRESA_DESFAVORABLE) {
            return new Desfavorable(posicion);
        }

        if (probabilidadGeneracion < PROBABILIDAD_GENERACION_SORPRESA_CAMBIO_DE_VEHICULO) {
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
