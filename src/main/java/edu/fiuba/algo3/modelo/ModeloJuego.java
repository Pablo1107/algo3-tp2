package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.juego.PartidaMultijugador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class ModeloJuego {
    private static ModeloJuego instancia;

    private PartidaMultijugador partida;

    public static ModeloJuego getInstancia() {
        if (instancia == null) {
            instancia = new ModeloJuego();
        }

        return instancia;
    }

    private ModeloJuego() {
        this.partida = new PartidaMultijugador();
    }

    public void iniciarNuevaPartida() {
        this.partida.iniciarNuevaPartida();
    }

    public PartidaMultijugador getPartidaActual() {
        return this.partida;
    }

    public void jugarTurno(Direccion direccion) {
        if (!instancia.getPartidaActual().estaEnCurso()) {
            return;
        }

        this.partida.jugarTurno(direccion);
    }

    public Jugador getJugador() {
        return this.partida.getJugador();
    }

    public Mapa getMapa() {
        return this.partida.getMapa();
    }

    public Posicion getPosicionMeta() {
        return this.partida.getMeta().getPosicion();
    }
}
