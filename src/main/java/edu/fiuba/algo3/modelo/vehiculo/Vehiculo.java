package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;

public abstract class Vehiculo {
	protected int penalizaciones;

	public Vehiculo() {
		this.penalizaciones = 0;
	}

	public abstract boolean pisar(Obstaculo obstaculo);

	public void reducirPenalizaciones() {
		this.penalizaciones--;
	}

	public boolean tienePenalizaciones() {
		return this.penalizaciones > 0;
	}
}
