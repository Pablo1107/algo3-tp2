package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class PartidaMultijugador {
    private static final Posicion POSICION_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();

    private Jugador jugador;
    private Mapa mapa;

    public PartidaMultijugador(Mapa mapa) {
        this.jugador = new Jugador(POSICION_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
        this.mapa = mapa;
    }

    public void jugarTurno(Direccion direccion) {
        this.jugador.avanzar(direccion, this.mapa);
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public void iniciar() {
        this.jugador = new Jugador(POSICION_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
    }
}
