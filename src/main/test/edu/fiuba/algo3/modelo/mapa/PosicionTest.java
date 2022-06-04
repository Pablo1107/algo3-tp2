package edu.fiuba.algo3.modelo.mapa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PosicionTest {
	@Test
	public void alCrearUnaPosicionSusValoresDeXeYSonLosEsperados() {
		Posicion posicion = new Posicion(10, 10);
		int xEsperado = 10;
		int yEsperado = 10;

		assertEquals(posicion.getX(), xEsperado, "La coordenada X de la posicion coincide con el esperado");
		assertEquals(posicion.getY(), yEsperado, "La coordenada Y de la posicion coincide con el esperado");
	}

	@Test
	public void alDesplazarUnaPosicionEnUnaDireccionDadaSeLlegaALaPosicionEsperada() {
		Posicion posicionInicial = new Posicion(10, 10);
		Direccion direccion = new Direccion(5, 7);
		Posicion posicionEsperada = new Posicion(15,  17);

		Posicion posicionLlegada = posicionInicial.desplazar(direccion);

		assertEquals(posicionLlegada, posicionEsperada, "La posicion a la que se llego luego de desplazarse es la esperada");
	}

	@Test
	public void dadasDosPosicionesEstasSonComparablesEntreSi() {
		Posicion posicion1 = new Posicion(10, 10);
		Posicion posicion2 = new Posicion(10, 10);

		assertEquals(posicion1, posicion2, "Dos posiciones con las mismas coordenadas son efectivamente iguales");

		posicion1 = new Posicion(10, 5);
		posicion2 = new Posicion(4, 12);

		assertNotEquals(posicion1, posicion2, "Dos posiciones con coordenadas completamente diferentes no son la misma posicion");

		posicion1 = new Posicion(4, 5);
		posicion2 = new Posicion(4, 12);

		assertNotEquals(posicion1, posicion2, "Dos posiciones con tan solo una coordenada diferente no son la misma posicion");
	}

	@Test
	public void dadaUnaPosicionYOtroObjetoCualqueiraNoSonComparablesEntreSi() {
		Posicion posicion = new Posicion(10, 10);
		Direccion direccion = new Direccion(10, 10);

		assertNotEquals(posicion, direccion, "Una posicion y direccion, aunque tengan las mismas coordenadas, no son efectivamente iguales");
	}
}
