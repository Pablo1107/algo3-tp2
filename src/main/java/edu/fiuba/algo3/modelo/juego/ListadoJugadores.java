package edu.fiuba.algo3.modelo.juego;

import java.util.Iterator;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ListadoJugadores implements Iterable<Jugador> {
    private List<Jugador> listadoJugadores;
    private int indiceJugadorEnTurno;

    public ListadoJugadores(List<Jugador> listadoJugadores) {
        this.listadoJugadores = listadoJugadores;
        this.indiceJugadorEnTurno = 0;
    }

    public Iterator<Jugador> iterator() {
        Iterator<Jugador> it = new Iterator<Jugador>() {
			@Override
			public boolean hasNext() {
                return indiceJugadorEnTurno < listadoJugadores.size();
			}

			@Override
			public Jugador next() {
                if (listadoJugadores.size() == 0) {
                    return null;
                }

                if (this.hasNext()) {
                    return listadoJugadores.get(indiceJugadorEnTurno++);
                }

                indiceJugadorEnTurno = 0;
				return listadoJugadores.get(indiceJugadorEnTurno);
			}
        };

        return it;
    }

    public List<Jugador> obtenerListadoJugadores() {
        return this.listadoJugadores;
    }
}
