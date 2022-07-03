package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.juego.PartidaMultijugador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class ModeloJuego {
    private static ModeloJuego instancia;

    private boolean juegoTerminado;
    private PartidaMultijugador partida;

    private ModeloJuego() {
        this.juegoTerminado = false;
        this.partida = this.crearPartida();
    }

    private PartidaMultijugador crearPartida() {
        return new PartidaMultijugador();
    }

    public static ModeloJuego getInstancia() {
        if (instancia == null) {
            instancia = new ModeloJuego();
        }

        return instancia;
    }

    public void reiniciarJuego() {
        this.juegoTerminado = false;
        this.partida.iniciar();
    }

    public void terminarJuego() {
        instancia.juegoTerminado = true;
    }

    public void jugarTurno(Direccion direccion) {
        if (instancia.juegoTerminado) {
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

    public boolean getJuegoTerminado() {
        return instancia.juegoTerminado;
    }

    public Posicion getPosicionMeta() {
        return this.partida.getMeta().getPosicion();
    }
}
