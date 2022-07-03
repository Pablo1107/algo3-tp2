package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.juego.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.mapa.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Favorable;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class ModeloJuego {
    private static final Posicion POS_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();
    private static final int MAPA_LIMITE_X = 15;
    private static final int MAPA_LIMITE_Y = 10;

    private static ModeloJuego instancia;

    private Jugador jugador;
    private Mapa mapa;
    private Meta meta;

    private boolean juegoTerminado;
    private List<Partida> registroPartidas;

    private ModeloJuego() {
        this.jugador = new Jugador(POS_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
        this.mapa = new Mapa(MAPA_LIMITE_X, MAPA_LIMITE_Y);
        this.meta = this.crearMetaEnFilaAleatoria();

        this.juegoTerminado = false;
        this.registroPartidas = new ArrayList<>();
        this.inicializarJuego();
    }

    public static ModeloJuego getInstancia() {
        if (instancia == null) {
            instancia = new ModeloJuego();
        }

        return instancia;
    }

    private void inicializarJuego() {
        this.mapa.agregarElemento(this.meta);
        this.mapa.agregarElemento(new ElementoNulo(POS_INICIAL_JUGADOR));

        for (int i = 0; i < this.mapa.getLimiteX(); i++) {
            for (int j = 0; j < this.mapa.getLimiteY(); j++) {
                Posicion posicion = new Posicion(i, j);
                this.mapa.agregarElemento(this.generarElementoRandom(posicion));
            }
        }
    }

    private Meta crearMetaEnFilaAleatoria() {
        int filaRandom = (int)Math.floor(Math.random() * (this.mapa.getLimiteY() - 1));
        Posicion posicionMeta = new Posicion(this.mapa.getLimiteX() - 1, filaRandom);
        return new Meta(posicionMeta);
    }

    public void reiniciarJuego() {
        this.juegoTerminado = false;
        this.jugador = new Jugador(POS_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
    }

    public void terminarJuego() {
        Partida resultado = new Partida(instancia.getJugador().getMovimientos());
        this.registroPartidas.add(resultado);
        instancia.juegoTerminado = true;
    }

    public void jugarTurno(Direccion direccion) {
        if (instancia.juegoTerminado) {
            return;
        }

        this.jugador.avanzar(direccion, this.mapa);
    }

    private Elemento generarElementoRandom(Posicion posicion) {
        double random = Math.random();
        if (random < 0.1) {
            return new Pozo(posicion);
        }

        if (random < 0.2) {
            return new Piquete(posicion);
        }

        if (random < 0.3) {
            return new ControlPolicial(posicion);
        }

        if (random < 0.33) {
            return new Favorable(posicion);
        }

        if (random < 0.36) {
            return new Desfavorable(posicion);
        }

        if (random < 0.4) {
            return new CambioDeVehiculo(posicion);
        }

        return new ElementoNulo(posicion);

    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public Mapa getMapa() {
        return this.mapa;
    }

    public List<Partida> getPartidas() {
        return this.registroPartidas;
    }

    public boolean getJuegoTerminado() {
        return instancia.juegoTerminado;
    }

    public Posicion getPosicionMeta() {
        System.out.println(this.meta.getPosicion().getX());
        System.out.println(this.meta.getPosicion().getY());
        return this.meta.getPosicion();
    }
}
