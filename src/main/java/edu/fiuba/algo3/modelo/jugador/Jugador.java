package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.vehiculo.IVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class Jugador {
	Posicion posicion;
	IVehiculo vehiculo;
	int movimientos;

    public Jugador(Posicion posicionInicial) {
		posicion = posicionInicial;
		vehiculo = new Moto();
		movimientos = 0;
    }

	// TODO: El tener que pasarle el mapa al jugador me hace ruido.
	public void mover(Direccion direccion, Mapa mapa) {
		Posicion nuevaPosicion = posicion.desplazar(direccion);

		if (!mapa.posicionEstaDentroDelMapa(nuevaPosicion)) {
			return;
		}

		posicion = posicion.desplazar(direccion);
		movimientos += 1;

		Obstaculo obstaculoEnPosicion = mapa.getElementoEnPosicion(posicion);
		movimientos += vehiculo.getPenalizacionObstaculo(obstaculoEnPosicion);
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public int getMovimientos() {
		return movimientos;
	}
}
