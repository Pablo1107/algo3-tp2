package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;

public class Moto extends Vehiculo {
	public Moto() {
		this.penalizaciones = 0;
	}

	public void pisar(Obstaculo obstaculo) {
		this.penalizaciones += obstaculo.getPenalizacion(this);
	}

	public void reducirPena() {
		this.penalizaciones--;
	}

	public int getPenalizaciones() {
		return this.penalizaciones;
	}
}
