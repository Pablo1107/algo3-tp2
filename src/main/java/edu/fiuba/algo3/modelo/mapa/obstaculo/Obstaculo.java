package edu.fiuba.algo3.modelo.mapa.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Auto;

public abstract class Obstaculo {
	public abstract int getPenalizacion(Moto moto);

	public abstract int getPenalizacion(Auto auto);

	public abstract int getPenalizacion(CuatroXCuatro cuatroXCuatro);
}
