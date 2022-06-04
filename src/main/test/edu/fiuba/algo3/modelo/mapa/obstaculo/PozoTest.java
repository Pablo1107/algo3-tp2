package edu.fiuba.algo3.modelo.mapa.obstaculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PozoTest {
	@Test
	public void laPenalizacionDeUnPozoParaUnaMotoEsCero() {
		Pozo obstaculo = new Pozo();

		assertEquals(3, obstaculo.getPenalizacionMoto());
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnAutoEsCero() {
		Pozo obstaculo = new Pozo();

		// Aqui realmente deberia depender de la cantidad de pozos que se
		// hayan pasado antes, pero no se ha implementado eso aun.
		assertEquals(3, obstaculo.getPenalizacionAuto());
	}

	@Test
	public void laPenalizacionDeUnPozoParaUnCuatroXCuatroEsCero() {
		Pozo obstaculo = new Pozo();

		assertEquals(2, obstaculo.getPenalizacionCuatroXCuatro());
	}
}
