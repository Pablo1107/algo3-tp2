package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;

public abstract class Vehiculo {
	protected int penalizaciones;

	public abstract void pisar(Obstaculo obstaculo);
	public abstract void reducirPena();
	public abstract int getPenalizaciones();
}
