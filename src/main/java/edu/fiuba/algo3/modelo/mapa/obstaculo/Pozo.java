package edu.fiuba.algo3.modelo.mapa.obstaculo;

public class Pozo extends Obstaculo {
	public int getPenalizacionMoto() {
		return 3;
	}

	public int getPenalizacionAuto() {
		return 3;
	}

	public int getPenalizacionCuatroXCuatro() {
		return 2;
	}
}
