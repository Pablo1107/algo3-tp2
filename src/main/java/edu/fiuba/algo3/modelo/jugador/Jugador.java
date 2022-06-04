package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.coordenada.Coordenada;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class Jugador {
	Coordenada posicion;

    public Jugador(Coordenada posicionInicial) {
		posicion = posicionInicial;
    }

	public Coordenada getPosicion() {
		return posicion;
	}

	public void mover(Coordenada direccion, Mapa mapa) {
		Coordenada nuevaPosicion = posicion.desplazar(direccion);

		if (!mapa.posicionEstaDentroDeLosLimites(nuevaPosicion)) {
			return;
		}

		posicion = nuevaPosicion;
	}
}
