package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.coordenada.Direccion;
import edu.fiuba.algo3.modelo.coordenada.Posicion;

public class JugadorTest {
	@Test
	public void alCrearAlJugadorEsteEstaUbicadoEnLaPosicionEspecificada() {
		Posicion posicionInicial = new Posicion(10, 10);
		Jugador jugador = new Jugador(posicionInicial);

		assertEquals(posicionInicial, jugador.getPosicion(), "La coordenada inicial en del jugador es la esperada");
	}

	@Test
	public void alMoverAlJugadorDePosicionLaNuevaPosicionDelJugadorEsLaEsperada() {
		Posicion posicionInicial = new Posicion(0, 0);
		Jugador jugador = new Jugador(posicionInicial);
		Direccion direccion = new Direccion(1, 1);
		Posicion posicionEsperada = new Posicion(1, 1);

		jugador.mover(direccion);

		assertEquals(posicionEsperada, jugador.getPosicion(), "La coordenada del jugador luego de moverse es la esperada");
	}
}
