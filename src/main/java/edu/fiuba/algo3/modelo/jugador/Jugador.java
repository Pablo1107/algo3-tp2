package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador {
	private Posicion posicion;
	private Vehiculo vehiculo;
	private int movimientos;

    public Jugador(Posicion posicionInicial, Vehiculo vehiculo) {
		this.posicion = posicionInicial;
		this.vehiculo = vehiculo;
		this.movimientos = 0;
    }

	public void mover(Direccion direccion, Mapa mapa) {
		if (this.vehiculo.tienePenalizaciones()) {
			this.vehiculo.reducirPenalizaciones();
			return;
		}

		Posicion nuevaPosicion = posicion.desplazar(direccion);

		if (!mapa.posicionEstaDentroDelMapa(nuevaPosicion)) {
			return;
		}

		this.posicion = nuevaPosicion;
		this.movimientos++;

		Obstaculo obstaculo = mapa.getElementoEnPosicion(posicion);
		obstaculo.chocarCon(this.vehiculo);
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public int getMovimientos() {
		return this.movimientos;
	}
}
