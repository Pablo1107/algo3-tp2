package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.Posicion;

public class JuegoTest {
	@Test
	public void noSePuedePosicionarUnJugadorFueraDelMapa() {
		Juego juego = new Juego(new Posicion(30, 30));
		
		Exception excepcion = assertThrows(RuntimeException.class, () -> {
			juego.inicializar();
		});

		String mensajeRecibido = excepcion.getMessage();
		String mensajeEsperado = "No se puede posicionar un elemento fuera del mapa";

		assertEquals(mensajeEsperado, mensajeRecibido,  "No se puede posicionar un elemento fuera del mapa");
	}
}
