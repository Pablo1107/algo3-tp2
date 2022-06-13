package edu.fiuba.algo3.casos_de_uso;

import org.junit.jupiter.api.Test;

public class PenalizacionesPozoIntegracionTest {
    @Test
    public void unaMotoSePosicionaSobreUnPozoYNoSePuedeMoverPorLosSiguienteTresTurnos() {
        // 		Moto moto = new Moto();
        // 		Jugador jugador = new Jugador(new Posicion(0, 0), moto);
        // 		Mapa mapa = new Mapa(10, 10);
        // 
        // 		mapa.setElementoEnPosicion(new Pozo(), new Posicion(1, 0));
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertTrue(moto.tienePenalizaciones());
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertTrue(moto.tienePenalizaciones());
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertTrue(moto.tienePenalizaciones());
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertFalse(moto.tienePenalizaciones());
        // 
        // 		assertEquals(new Posicion(1, 0), jugador.getPosicion());
    }

    @Test
    public void unAutoSePosicionaSobreUnPozoYNoSePuedeMoverPorLosSiguienteTresTurnos() {
        // 		Auto auto = new Auto();
        // 		Jugador jugador = new Jugador(new Posicion(0, 0), auto);
        // 		Mapa mapa = new Mapa(10, 10);
        // 
        // 		mapa.setElementoEnPosicion(new Pozo(), new Posicion(1, 0));
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertTrue(auto.tienePenalizaciones());
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertTrue(auto.tienePenalizaciones());
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertTrue(auto.tienePenalizaciones());
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertFalse(auto.tienePenalizaciones());
        // 
        // 		assertEquals(new Posicion(1, 0), jugador.getPosicion());
    }

    @Test
    public void unCuatroXCuatroSePosicionaSobreUnPozoPorPrimeraYSegundaVezYNoRecibePenalizacion() {
        // 		CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        // 		Jugador jugador = new Jugador(new Posicion(0, 0), cuatroXCuatro);
        // 		Mapa mapa = new Mapa(10, 10);
        // 
        // 		mapa.setElementoEnPosicion(new Pozo(), new Posicion(1, 0));
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertFalse(cuatroXCuatro.tienePenalizaciones());
        // 
        // 		jugador.mover(new Direccion(1, 0), mapa);
        // 		assertFalse(cuatroXCuatro.tienePenalizaciones());
        // 
        // 		assertEquals(new Posicion(2, 0), jugador.getPosicion());
    }

    @Test
    public void unCuatroXCuatroPisaTresPozosYNoSePuedeMoverPorLosSiguienteDosTurnos() {
        // 		CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        // 		Jugador jugador = new Jugador(new Posicion(0, 0), cuatroXCuatro);
        // 		Mapa mapa = new Mapa(10, 10);
        // 		Direccion derecha = new Direccion(1,0);
        // 
        // 		mapa.setElementoEnPosicion(new Pozo(), new Posicion(1, 0));
        // 		mapa.setElementoEnPosicion(new Pozo(), new Posicion(2, 0));
        // 		mapa.setElementoEnPosicion(new Pozo(), new Posicion(3, 0));
        // 
        // 		jugador.mover(derecha, mapa);
        // 		assertFalse(cuatroXCuatro.tienePenalizaciones());
        // 
        // 		jugador.mover(derecha, mapa);
        // 		assertFalse(cuatroXCuatro.tienePenalizaciones());
        // 
        // 		jugador.mover(derecha, mapa);
        // 		assertTrue(cuatroXCuatro.tienePenalizaciones());
        // 
        // 		jugador.mover(derecha, mapa);
        // 		assertTrue(cuatroXCuatro.tienePenalizaciones());
        // 
        // 		jugador.mover(derecha, mapa);
        // 		assertFalse(cuatroXCuatro.tienePenalizaciones());
        // 
        // 		assertEquals(new Posicion(3, 0), jugador.getPosicion());
    }
}
