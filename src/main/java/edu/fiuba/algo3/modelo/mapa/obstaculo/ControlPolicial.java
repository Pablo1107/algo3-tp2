package edu.fiuba.algo3.modelo.mapa.obstaculo;

import java.util.Random;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ControlPolicial extends Obstaculo {
	public int aplicarPenalizacion(Moto moto) {
		return this.aplicarPenalizacionConProbabilidad(8);
	}

	public int aplicarPenalizacion(Auto auto) {
		return this.aplicarPenalizacionConProbabilidad(5);
	}

	public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro) {
		return this.aplicarPenalizacionConProbabilidad(3);
	}

	private int aplicarPenalizacionConProbabilidad(int probabilidad) {
		return this.esPenalizado(probabilidad) ? 3 : 0;
	}

	private boolean esPenalizado(int probabilidad) {
		Random random = new Random();
		return (random.nextInt(probabilidad) == 0) ? true : false;
	}
}
