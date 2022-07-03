package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class PartidaMultijugador {
    private static final Posicion POSICION_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();
    private static final int MAPA_LIMITE_X = 15;
    private static final int MAPA_LIMITE_Y = 10;

    private Jugador jugador;
    private GeneradorMapa generadorMapa;

    public PartidaMultijugador() {
        this.iniciar();
    }

    public void iniciar() {
        this.jugador = new Jugador(POSICION_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
        this.generadorMapa = new GeneradorMapa(MAPA_LIMITE_X, MAPA_LIMITE_Y);
    }

    public void jugarTurno(Direccion direccion) {
        this.jugador.avanzar(direccion, this.generadorMapa.getMapa());
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public Mapa getMapa() {
        return this.generadorMapa.getMapa();
    }

    public Meta getMeta() {
        return this.generadorMapa.getMeta();
    }
}
