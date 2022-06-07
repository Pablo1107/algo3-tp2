package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculo.ObstaculoNulo;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Pozo;

public abstract class Vehiculo {
	protected int penalizaciones;

	public Vehiculo() {
		this.penalizaciones = 0;
	}

	public void pisar(ObstaculoNulo obstaculoNulo) {
		return;
	}

	public abstract void pisar(Pozo pozo);

	//	public void pisar(Piquete piquete);
	public abstract void pisar(ControlPolicial controlPolicial);

	public void reducirPenalizaciones() {
		this.penalizaciones--;
	}

	public boolean tienePenalizaciones() {
		return this.penalizaciones > 0;
	}
}
