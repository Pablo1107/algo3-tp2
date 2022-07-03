package edu.fiuba.algo3.modelo.juego;

import java.util.Iterator;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ListadoJugadores implements Iterable<Jugador> {
    private List<Jugador> listadoJugadores;
    private int jugadorEnTurno;

    public ListadoJugadores(List<Jugador> jugadores) {
        this.listadoJugadores = jugadores;
        this.jugadorEnTurno = 0;
    }

    public Iterator<Jugador> iterator() {
        Iterator<Jugador> it = new Iterator<Jugador>() {
			@Override
			public boolean hasNext() {
                return jugadorEnTurno < listadoJugadores.size();
			}

			@Override
			public Jugador next() {
                if (this.hasNext()) {
                    return listadoJugadores.get(jugadorEnTurno++);
                }

                jugadorEnTurno = 0;
				return listadoJugadores.get(jugadorEnTurno);
			}
        };

        return it;
    }

    public List<Jugador> getListadoJugadores() {
        return this.listadoJugadores;
    }
}
