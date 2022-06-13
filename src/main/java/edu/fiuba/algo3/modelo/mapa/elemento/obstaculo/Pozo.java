package edu.fiuba.algo3.modelo.mapa.elemento.obstaculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class Pozo extends Obstaculo {
	private final static int PENALIZACION_MOTO = 3;
	private final static int PENALIZACION_AUTO = 3;
	private final static int PENALIZACION_CUATROXCUATRO = 2;
	public Pozo(Posicion posicion) {
		super(posicion);
	}

	@Override
	public void chocarCon(Jugador jugador) {
		jugador.getVehiculo().pisar(this);
	}

	public int aplicarPenalizacion(Moto moto) {
		return Pozo.PENALIZACION_MOTO;
	}

	public int aplicarPenalizacion(Auto auto) {
		return Pozo.PENALIZACION_AUTO;
	}

	public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro) {
		return Pozo.PENALIZACION_CUATROXCUATRO;
	}
}
