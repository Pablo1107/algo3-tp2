package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.obstaculo.Pozo;

public class Moto {
	public Moto() {
	}

	int evaluarPenalizacion(Pozo pozo) {
		return pozo.penalizacionMoto();
	}
}
