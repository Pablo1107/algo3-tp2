package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;

public interface IVehiculo {
	public abstract void pisar(Obstaculo obstaculo);

	public void reducirPenalizaciones();

	public boolean tienePenalizaciones();
}
