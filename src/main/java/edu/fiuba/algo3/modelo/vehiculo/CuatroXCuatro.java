package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.Pozo;

public class CuatroXCuatro extends Vehiculo {
    private int pozosPisados;

	public CuatroXCuatro() {
		this.pozosPisados = 0;
	}

	private void pisar(Obstaculo obstaculo) {
		this.penalizaciones += obstaculo.aplicarPenalizacion(this);
	}

	public void pisar(Pozo pozo) {
		this.pozosPisados++;
		if (this.pozosPisados < 3) { return; }
		this.pisar((Obstaculo)pozo);
		this.pozosPisados = 0;
   }

	public void pisar(ControlPolicial controlPolicial) {
		this.pisar((Obstaculo)controlPolicial);
	}
}
