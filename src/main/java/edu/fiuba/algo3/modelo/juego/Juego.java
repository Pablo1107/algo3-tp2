package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class Juego {
	Jugador jugador;
	Mapa mapa;

	public Juego(Posicion posicionInicialJugador) {
		jugador = new Jugador(posicionInicialJugador);
		mapa = new Mapa(20, 20);
	}

	public void inicializar() {
		mapa.setElementoEnPosicion(new Elemento(), jugador.getPosicion());
		inicializarMapa();
	}

	private void inicializarMapa() {
	}

	public void turno() {
	}
}
