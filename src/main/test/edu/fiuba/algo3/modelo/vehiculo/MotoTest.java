package edu.fiuba.algo3.modelo.vehiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.obstaculo.ObstaculoNulo;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Pozo;

public class MotoTest {
	@Test
	public void alPosicionarUnaMotoSobreUnPozoSeRetornaLaPenalizacionCorrespondiente() {
		Moto moto = new Moto();
		Pozo pozo = new Pozo();

		assertEquals(moto.getPenalizacionObstaculo(pozo), 3);
	}

	@Test
	public void alPosicionarUnaMotoSobreUnaPosicionVaciaSeRetornaLaPenalizacionCorrespondiente() {
		Moto moto = new Moto();

		assertEquals(moto.getPenalizacionObstaculo(new ObstaculoNulo()), 0);
	}
}
