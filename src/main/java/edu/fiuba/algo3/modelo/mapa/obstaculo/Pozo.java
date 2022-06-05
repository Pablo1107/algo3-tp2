package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class Pozo extends Obstaculo {
	public int getPenalizacion(Moto moto) {
		return 3;
	}

	public int getPenalizacion(Auto auto) {
		return 3;
	}

//	public int getPenalizacion(CuatroXCuatro cuatroXCuatro) {
//		return 2;
//	}
}
