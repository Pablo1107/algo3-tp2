package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Pozo extends Obstaculo {
	public void chocarCon(Vehiculo vehiculo) {
		vehiculo.pisar(this);
	}

	public int aplicarPenalizacion(Moto moto) {
		return 3;
	}

	public int aplicarPenalizacion(Auto auto) {
		return 3;
	}

	public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro) {
		return 2;
	}
}
