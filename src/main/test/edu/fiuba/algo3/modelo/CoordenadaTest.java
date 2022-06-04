package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.coordenada.Coordenada;

public class CoordenadaTest {
	@Test
	public void alCrearUnaCoordenadaSusValoresDeXeYSonLosEsperados() {
		Coordenada coordenada = new Coordenada(10, 10);
		int xEsperado = 10;
		int yEsperado = 10;

		assertEquals(coordenada.getX(), xEsperado, "El valor de la coordenada en X es el esperado");
		assertEquals(coordenada.getY(), yEsperado, "El valor de la coordenada en Y es el esperado");
	}

	@Test
	public void alDesplazarUnaCoordenadaEnUnaDireccionDadaLlegaALaCoordenadaEsperada() {
		Coordenada coordenada = new Coordenada(10, 10);
		Coordenada direccion = new Coordenada(5, 7);
		Coordenada coordenadaEsperada = new Coordenada(15,  17);

		Coordenada coordenadaLlegada = coordenada.desplazar(direccion);

		assertEquals(coordenadaLlegada, coordenadaEsperada, "Al desplazar una coordenada en una direccion se llega a la coordenada esperada");
	}
}
