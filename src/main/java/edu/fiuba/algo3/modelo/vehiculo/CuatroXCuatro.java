package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;

public class CuatroXCuatro extends Vehiculo {
    private int cantidadPozosPasadosAnteriomente;

	public CuatroXCuatro() {
		this.cantidadPozosPasadosAnteriomente = 0;
	}

	public void pisar(Obstaculo obstaculo) {
		this.cantidadPozosPasadosAnteriomente++;

		if (this.cantidadPozosPasadosAnteriomente < 3) {
			return;
		}

		this.penalizaciones += obstaculo.aplicarPenalizacion(this);
		this.cantidadPozosPasadosAnteriomente = 0;
	}
}
