package edu.fiuba.algo3.modelo.coordenada;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	public void noSePuedeCrearUnaPosicionConCoordenadasNegativas() {
		Exception excepcion = assertThrows(RuntimeException.class, () -> {
			new Posicion(-10, -10);
		});

		String mensajeRecibido = excepcion.getMessage();
		String mensajeEsperado = "No se puede crear una posicion con coordenadas negativas";

		assertEquals(mensajeRecibido, mensajeEsperado, "Se lanza la excepcion correcta al intentar crear una posicion con coordenadas negativas");
	}

	@Test
	public void alDesplazarUnaPosicionEnUnaDireccionDadaSeLlegaALaPosicionEsperada() {
		Posicion posicionInicial = new Posicion(10, 10);
		Direccion direccion = new Direccion(5, 7);
		Posicion posicionEsperada = new Posicion(15,  17);

		Posicion posicionLlegada = posicionInicial.desplazar(direccion);

		assertEquals(posicionLlegada, posicionEsperada, "La posicion a la que se llego luego de desplazarse es la esperada");
	}
}
