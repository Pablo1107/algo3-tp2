package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class Pozo extends Obstaculo {
	public int aplicarPenalizacion(Moto moto, int penalizacion) {
		return penalizacion + 3;
	}

	@Override
	public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro, int penalizacion) {
		return penalizacion;
	}

	public int aplicarPenalizacion(Auto auto, int penalizacion) {
		return penalizacion + 3;
	}

	@Override
	public boolean equals(Object o) {
		return true;
	}
}
