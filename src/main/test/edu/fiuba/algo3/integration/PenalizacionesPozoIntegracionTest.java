package edu.fiuba.algo3.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class PenalizacionesPozoIntegracionTest {
	@Test
	public void unaMotoSePosicionaSobreUnPozoYNoSePuedeMoverPorLosSiguienteTresTrunos() {
		Moto moto = new Moto();
		Jugador jugador = new Jugador(new Posicion(0, 0), moto);
		Mapa mapa = new Mapa(10, 10);

		mapa.setElementoEnPosicion(new Pozo(), new Posicion(1, 0));

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(moto.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(moto.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(moto.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertFalse(moto.tienePenalizaciones());

		assertEquals(new Posicion(1, 0), jugador.getPosicion());
	}

	@Test
	public void unAutoSePosicionaSobreUnPozoYNoSePuedeMoverPorLosSiguienteTresTrunos() {
		Auto auto = new Auto();
		Jugador jugador = new Jugador(new Posicion(0, 0), auto);
		Mapa mapa = new Mapa(10, 10);

		mapa.setElementoEnPosicion(new Pozo(), new Posicion(1, 0));

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(auto.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(auto.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(auto.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertFalse(auto.tienePenalizaciones());

		assertEquals(new Posicion(1, 0), jugador.getPosicion());
	}

	@Test
	public void unCuatroXCuatroSePosicionaSobreUnPozoPorPrimeraYSegundaVezYNoRecibePenalizacion() {
		CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
		Jugador jugador = new Jugador(new Posicion(0, 0), cuatroXCuatro);
		Mapa mapa = new Mapa(10, 10);

		mapa.setElementoEnPosicion(new Pozo(), new Posicion(1, 0));

		jugador.mover(new Direccion(1, 0), mapa);
		assertFalse(cuatroXCuatro.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertFalse(cuatroXCuatro.tienePenalizaciones());

		assertEquals(new Posicion(2, 0), jugador.getPosicion());
	}

	@Test
	public void unCuatroXCuatroSePosicionaSobreUnPozoYNoSePuedeMoverPorLosSiguienteDosTrunos() {
		CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
		Jugador jugador = new Jugador(new Posicion(0, 0), cuatroXCuatro);
		Mapa mapa = new Mapa(10, 10);

		mapa.setElementoEnPosicion(new Pozo(), new Posicion(1, 0));
		mapa.setElementoEnPosicion(new Pozo(), new Posicion(2, 0));
		mapa.setElementoEnPosicion(new Pozo(), new Posicion(3, 0));

		jugador.mover(new Direccion(1, 0), mapa);
		assertFalse(cuatroXCuatro.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertFalse(cuatroXCuatro.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(cuatroXCuatro.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(cuatroXCuatro.tienePenalizaciones());

		jugador.mover(new Direccion(1, 0), mapa);
		assertFalse(cuatroXCuatro.tienePenalizaciones());

		assertEquals(new Posicion(3, 0), jugador.getPosicion());
	}
}
