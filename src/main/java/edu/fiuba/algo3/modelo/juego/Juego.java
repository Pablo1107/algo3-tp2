package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Juego {
	private Jugador jugador;
	private Mapa mapa;

	private static final Posicion POSICION_INICIAL_JUGADOR = new Posicion(0, 0);
	private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();
	private static final int ANCHO_MAPA = 20;
	private static final int ALTURA_MAPA = 20;

	public Juego() {
		this.jugador = new Jugador(POSICION_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
		this.mapa = new Mapa(ANCHO_MAPA, ALTURA_MAPA);
	}

	public void iniciar() {
		this.generarMapa();
	}

	private void generarMapa() {
		this.mapa.setElementoEnPosicion(new Pozo(), new Posicion(10, 10));
	}
}
