package edu.fiuba.algo3.integration;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.elemento.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PenalizacionesControlPolicialIntegracionTest {
	@Test
	public void unaMotoSePosicionaSobreUnControlPolicialYPuedeONoSerPenalizado() {
		Moto moto = new Moto();
		Jugador jugador = new Jugador(new Posicion(0, 0), moto);
		Mapa mapa = new Mapa(10, 10);

		mapa.setElementoEnPosicion(new ControlPolicial(), new Posicion(1, 0));

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(moto.getPenalizaciones() == 0 || moto.getPenalizaciones() == 3);
	}

	@Test
	public void unAutoSePosicionaSobreUnControlPolicialYPuedeONoSerPenalizado() {
		Auto auto = new Auto();
		Jugador jugador = new Jugador(new Posicion(0, 0), auto);
		Mapa mapa = new Mapa(10, 10);

		mapa.setElementoEnPosicion(new ControlPolicial(), new Posicion(1, 0));

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(auto.getPenalizaciones() == 0 || auto.getPenalizaciones() == 3);
	}

	@Test
	public void unaCuatroXCuatroSePosicionaSobreUnControlPolicialYPuedeONoSerPenalizado() {
		CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
		Jugador jugador = new Jugador(new Posicion(0, 0), cuatroXCuatro);
		Mapa mapa = new Mapa(10, 10);

		mapa.setElementoEnPosicion(new ControlPolicial(), new Posicion(1, 0));

		jugador.mover(new Direccion(1, 0), mapa);
		assertTrue(cuatroXCuatro.getPenalizaciones() == 0 || cuatroXCuatro.getPenalizaciones() == 3);
	}
}
