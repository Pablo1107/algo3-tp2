package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.coordenada.Direccion;
import edu.fiuba.algo3.modelo.coordenada.Posicion;
import edu.fiuba.algo3.modelo.mapa.IValidadorDePosicion;

public class Jugador {
	Posicion posicion;

    public Jugador(Posicion posicionInicial) {
		posicion = posicionInicial;
    }

	public Posicion getPosicion() {
		return posicion;
	}

	public void mover(Direccion direccion, IValidadorDePosicion validadorPosicion) {
		Posicion nuevaPosicion = posicion.desplazar(direccion);

		if (!validadorPosicion.validar(nuevaPosicion)) {
			return;
		}

		posicion = nuevaPosicion;
	}
}
