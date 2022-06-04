package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class Jugador {
	Posicion posicion;

    public Jugador(Posicion posicionInicial) {
		posicion = posicionInicial;
    }

	public Posicion getPosicion() {
		return posicion;
	}

	public void mover(Direccion direccion) {
		posicion = posicion.desplazar(direccion);
	}
}
