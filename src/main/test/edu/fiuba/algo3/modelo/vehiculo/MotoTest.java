package edu.fiuba.algo3.modelo.vehiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.obstaculo.ObstaculoNulo;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Pozo;

public class MotoTest {
	@Test
	public void alPosicionarUnaMotoSobreUnPozoAumentaSuPenalizacionEnTres() {
		Moto moto = new Moto();
		Pozo pozo = new Pozo();

		moto.pisar(pozo);
		assertEquals(3, moto.getPenalizaciones());
	}

	@Test
	public void alPosicionarUnaMotoSobreUnaPosicionVaciaSeRetornaLaPenalizacionCorrespondiente() {
		Moto moto = new Moto();
		int penalizacionInicial = moto.getPenalizaciones();

		moto.pisar(new ObstaculoNulo());
		assertEquals(penalizacionInicial, moto.getPenalizaciones());
	}
}
