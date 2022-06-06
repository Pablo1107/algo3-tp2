package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Auto;

public abstract class Obstaculo {
	public abstract int aplicarPenalizacion(Moto moto, int penalizacion);

	//public abstract int getPenalizacion(Auto auto);

	public abstract int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro, int penalizacion);

	//public abstract void aplicarPenalizacion(Moto moto, int penalizaciones);
	public abstract int aplicarPenalizacion(Auto auto, int penalizaciones);
	//public abstract void aplicarPenalizacion(CuatroXCuatro cuatroXCuatro, int penalizaciones);
	public boolean puedePasar(Obstaculo obstaculo) {
		return this.equals(obstaculo);
	}
	public abstract boolean equals(Object o);

}
