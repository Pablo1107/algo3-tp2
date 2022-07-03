package edu.fiuba.algo3.modelo.juego;

import java.util.Iterator;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class Partida {
    private ListadoJugadores listadoJugadores;
    private Mapa mapa;

    public Partida(List<Jugador> jugadores, Mapa mapa) {
        this.listadoJugadores = new ListadoJugadores(jugadores);
        this.mapa = mapa;
    }

    public void jugarTurno(Direccion direccion) {
        Iterator<Jugador> iteradorJugadores = this.listadoJugadores.iterator();
        Jugador siguienteJugador = iteradorJugadores.next();
        siguienteJugador.avanzar(direccion, this.mapa);
    }
    
    public List<Jugador> getListadoJugadores() {
        return this.listadoJugadores.getListadoJugadores();
    }
}
