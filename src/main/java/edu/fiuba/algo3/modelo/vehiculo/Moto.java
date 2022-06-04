package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;

public class Moto implements IVehiculo {
	public Moto() {
	}

	public int getPenalizacionObstaculo(Obstaculo obstaculo) {
		return obstaculo.getPenalizacionMoto();
	}
}
