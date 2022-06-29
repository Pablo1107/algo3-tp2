package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.mapa.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Favorable;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ModeloJuego {
    private static final Posicion POS_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();
    private static final int MAPA_LIMITE_X = 15;
    private static final int MAPA_LIMITE_Y = 10;
    private static final Posicion POS_META = new Posicion(MAPA_LIMITE_X-1, (MAPA_LIMITE_Y-1)/2);

    private static ModeloJuego instancia;

    private Jugador jugador;
    private Mapa mapa;
    private boolean juegoTerminado;
    private List<Partida> partidas;

    private ModeloJuego() {
        this.jugador = new Jugador(POS_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
        this.mapa = new Mapa(MAPA_LIMITE_X, MAPA_LIMITE_Y);
        this.juegoTerminado = false;
        this.partidas = new ArrayList<>();
        this.inicializarJuego();
    }

    public static ModeloJuego getInstancia() {
        if (ModeloJuego.instancia == null) {
            instancia = new ModeloJuego();
        }

        return ModeloJuego.instancia;
    }

    private void inicializarJuego() {
        this.mapa.agregarElemento(new Meta(POS_META));
        this.mapa.agregarElemento(new ElementoNulo(POS_INICIAL_JUGADOR)); //Agrego un elemento nulo en la posicion inicial del jugador

        for (int i  = 0; i < this.mapa.getLimiteX(); i++ ){
            for (int j = 0; j < this.mapa.getLimiteY(); j++ ) {
                Posicion posicion = new Posicion(i, j);
                this.mapa.agregarElemento(this.generarElementoRandom(posicion));
            }
        }
    }

    public void reiniciarJuego() {
        instancia.juegoTerminado = false;
        instancia = new ModeloJuego();
    }

    public void terminarJuego() {
        System.out.println(instancia.getJugador().getMovimientos());
        Partida resultado = new Partida(instancia.getJugador().getMovimientos());
        this.partidas.add(resultado);
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
        if (random < 0.2) {
            return new Pozo(posicion);
        }

        if (random < 0.4) {
            return new Piquete(posicion);
        } 

        if (random < 0.6) {
            return new ControlPolicial(posicion);
        }

        if (random < 0.66) {
            return new Favorable(posicion);
        }

        if (random < 0.72) {
            return new Desfavorable(posicion);
        }

        if (random < 0.8) {
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
        return this.partidas;
    }

    public boolean getJuegoTerminado() {
        return instancia.juegoTerminado;
    }

    public Posicion getPosicionMeta() {
        return POS_META;
    }
}
