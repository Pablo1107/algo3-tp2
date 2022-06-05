package edu.fiuba.algo3.modelo.jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class JugadorTest {
	@Test
	public void alCrearAlJugadorEsteEstaUbicadoEnLaPosicionEspecificada() {
		Posicion posicionInicial = new Posicion(10, 10);
		Jugador jugador = new Jugador(posicionInicial, new Moto());

		assertEquals(jugador.getPosicion(), posicionInicial);
	}

	@Test
	public void alMoverAlJugadorDePosicionLaNuevaPosicionDelJugadorEsLaEsperada() {
		Posicion posicionInicial = new Posicion(0, 0);
		Jugador jugador = new Jugador(posicionInicial, new Moto());
		Direccion direccion = new Direccion(1, 1);
		Posicion posicionEsperada = new Posicion(1, 1);
		Mapa mapa = new Mapa(10, 10);

		jugador.mover(direccion, mapa);

		assertEquals(jugador.getPosicion(), posicionEsperada);
	}

	@Test
	public void alIntentarMoverAlJugadorFueraDelMapaEsteQuedaEnLaMismaPosicionQueTeniaAntes() {
		Posicion posicionInicial = new Posicion(0, 0);
		Jugador jugador = new Jugador(posicionInicial, new Moto());
		Mapa mapa = new Mapa(5, 5);

		jugador.mover(new Direccion(10, 10), mapa);

		assertEquals(jugador.getPosicion(), posicionInicial);
	}

	@Test
	public void unJugadorEsCreadoConCeroMovimientos() {
		Jugador jugador = new Jugador(new Posicion(0, 0), new Moto());

		assertEquals(jugador.getMovimientos(), 0);
	}

	@Test
	public void alMoverUnJugadorHaciaUnaPosicionVaciaSuCantidadDeMovimientosAumentaEnUno() {
		Jugador jugador = new Jugador(new Posicion(0, 0), new Moto());
		Mapa mapa = new Mapa(5, 5);

		jugador.mover(new Direccion(1, 1), mapa);

		assertEquals(jugador.getMovimientos(), 1);
	}
}
