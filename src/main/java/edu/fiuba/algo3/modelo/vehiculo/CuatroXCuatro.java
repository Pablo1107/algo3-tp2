package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.obstaculo.ObstaculoNulo;

public class CuatroXCuatro extends Vehiculo {
    private int pozosPisados;

	public CuatroXCuatro() {
		this.pozosPisados = 0;
	}

	public void pisar(Obstaculo pozo) {
		if (pozo instanceof ObstaculoNulo) { return; }
		this.pozosPisados++;
		if (this.pozosPisados < 3) { return; }
		this.penalizaciones += pozo.aplicarPenalizacion(this);
		this.pozosPisados = 0;
   }
}
