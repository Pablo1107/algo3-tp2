package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.coordenada.Coordenada;

public class JugadorTest {
	@Test
	public void alCrearAlJugadorEsteEstaUbicadoEnLaPosicionEspecificada() {
		Coordenada posicionInicial = new Coordenada(10, 10);
		Jugador jugador = new Jugador(posicionInicial);

		assertEquals(posicionInicial, jugador.getPosicion(), "La coordenada inicial en del jugador es la esperada");
	}

	@Test
	public void alMoverAlJugadorDePosicionLaNuevaPosicionDelJugadorEsLaEsperada() {
		Coordenada posicionInicial = new Coordenada(0, 0);
		Jugador jugador = new Jugador(posicionInicial);
		Coordenada direccion = new Coordenada(1, 1);
		Coordenada posicionEsperada = new Coordenada(1, 1);

		// TODO: No me gasta esta forma en la que jugador tambien depende de mapa solo para moverse.
		Mapa mapa = new Mapa(10, 10);
		jugador.mover(direccion, mapa);

		assertEquals(posicionEsperada, jugador.getPosicion(), "La coordenada del jugador luego de moverse es la esperada");
	}

	@Test
	public void alIntentarMoverAlJugadorFueraDelMapaEsteQuedaEnLaMismaPosicionQueTeniaAntes() {
		Coordenada posicionInicial = new Coordenada(9, 9);
		Jugador jugador = new Jugador(posicionInicial);
		Coordenada direccion = new Coordenada(10, 10);

		Mapa mapa = new Mapa(10, 10);
		jugador.mover(direccion, mapa);

		assertEquals(jugador.getPosicion(), posicionInicial, "La posicion actual del jugador coincide con la que tenia antes");
	}
}
