package edu.fiuba.algo3.modelo.juego;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;

public class Partida {
    private ListadoJugadores jugadoresRegistrados;
    private final GeneradorMapa generadorMapa;
    private boolean estaEnCurso;

    public Partida(List<Jugador> jugadoresRegistrados, GeneradorMapa generadorMapa) {
        this.estaEnCurso = false;
        this.jugadoresRegistrados = new ListadoJugadores(jugadoresRegistrados);
        this.generadorMapa = generadorMapa;
    }

    public void turnoJugadorActual(Direccion direccion) {
        this.getJugadorEnTurno().avanzar(direccion, this.generadorMapa.getMapa());
    }

    public void turnoSiguienteJugador() {
        this.jugadoresRegistrados.turnoSiguienteJugador();
    }
    
    public Jugador getJugadorEnTurno() {
        return this.jugadoresRegistrados.getJugadorEnTurno();
    }

    public List<Jugador> getListadoJugadores() {
        return this.jugadoresRegistrados.getListadoJugadores();
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
}
