package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador {
	Posicion posicion;
	Vehiculo vehiculo;
	int movimientos;

    public Jugador(Posicion posicionInicial, Vehiculo vehiculo) {
		this.posicion = posicionInicial;
		this.vehiculo = vehiculo;
		this.movimientos = 0;
    }

	// TODO: El tener que pasarle el mapa al jugador me hace ruido.
	public void mover(Direccion direccion, Mapa mapa) {
		if (this.vehiculo.getPenalizaciones() > 0) {
			this.vehiculo.reducirPena();
			return;
		}

		Posicion nuevaPosicion = posicion.desplazar(direccion);

		if (!mapa.posicionEstaDentroDelMapa(nuevaPosicion)) {
			return;
		}

		this.posicion = nuevaPosicion;
		this.movimientos++;

		Obstaculo obstaculo = mapa.getElementoEnPosicion(posicion);
		this.vehiculo.pisar(obstaculo);
	}

	public int getPenalizaciones() {
		return this.vehiculo.getPenalizaciones();
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public int getMovimientos() {
		return this.movimientos;
	}
}
