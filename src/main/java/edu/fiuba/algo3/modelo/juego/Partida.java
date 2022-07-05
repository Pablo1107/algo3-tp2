package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Partida {
    private static final Posicion POSICION_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();

    private static final int MAPA_LIMITE_X = 15;
    private static final int MAPA_LIMITE_Y = 10;

    private final ListadoJugadores listadoJugadores;
    private final GeneradorMapa generadorMapa;
    private boolean estaEnCurso;

    public Partida() {
        this.estaEnCurso = true;
        this.listadoJugadores = new ListadoJugadores();
        this.generadorMapa = new GeneradorMapa(MAPA_LIMITE_X, MAPA_LIMITE_Y, POSICION_INICIAL_JUGADOR);
    }

    public void agregarJugador(String nombreJugador) {
        this.listadoJugadores.agregarJugador(new Jugador(nombreJugador, POSICION_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR));
    }

    public void jugarTurno(Direccion direccion) {
        if (this.listadoJugadores.getListadoJugadores().size() == 0) {
            return;
        }

        this.getJugadorEnTurno().avanzar(direccion, this.generadorMapa.getMapa());
    }

    public Jugador getJugadorEnTurno() {
        return this.listadoJugadores.getJugadorEnTurno();
    }

    public List<Jugador> getListadoJugadores() {
        return this.listadoJugadores.getListadoJugadores();
    }

    public Mapa getMapa() {
        return this.generadorMapa.getMapa();
    }

    public Meta getMeta() {
        return this.generadorMapa.getMeta();
    }

    public boolean estaEnCurso() {
        return this.estaEnCurso;
    }

    public void finalizar() {
        this.estaEnCurso = false;
    }

    public void turnoSiguienteJugador() {
        this.listadoJugadores.turnoSiguienteJugador(this);
    }
}
