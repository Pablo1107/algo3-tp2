package edu.fiuba.algo3.modelo.mapa.elemento.obstaculo;

import java.util.Random;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ControlPolicial extends Obstaculo {
	public ControlPolicial(Posicion posicion) {
		super(posicion);
	}
	/*public void chocarCon(Vehiculo vehiculo) {
		vehiculo.pisar(this);
	}*/

	private int aplicarPenalizacionConProbabilidad(int probabilidad) {
		return this.esPenalizado(probabilidad) ? 3 : 0;
	}

	@Override
	public void chocarCon(Jugador jugador) {
		jugador.getVehiculo().pisar(this);
	}

	public int aplicarPenalizacion(Moto moto) {
		return this.aplicarPenalizacionConProbabilidad(8);
	}

	public int aplicarPenalizacion(Auto auto) {
		return this.aplicarPenalizacionConProbabilidad(5);
	}

	public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro) {
		return this.aplicarPenalizacionConProbabilidad(3);
	}

	private boolean esPenalizado(int probabilidad) {
		Random random = new Random();
		return random.nextInt(probabilidad) == 0;
	}
}
