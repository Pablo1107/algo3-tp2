package edu.fiuba.algo3.integration;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class PenalizacionesObstaculoNuloIntegracionTest {
    @Test
    public void unaMotoSePosicionaSobreUnObstaculoNuloYNoRecibePenalizacion() {
        Moto moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(0, 0), moto);
        Mapa mapa = new Mapa(10, 10);

        jugador.mover(new Posicion(1, 0), mapa);
        assertFalse(moto.tienePenalizaciones());

        jugador.mover(new Posicion(1, 0), mapa);
        assertFalse(moto.tienePenalizaciones());

        jugador.mover(new Posicion(1, 0), mapa);
        assertFalse(moto.tienePenalizaciones());
    }

    @Test
    public void unAutoSePosicionaSobreUnObstaculoNuloYNoRecibePenalizacion() {
        Auto auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(0, 0), auto);
        Mapa mapa = new Mapa(10, 10);

        jugador.mover(new Posicion(1, 0), mapa);
        assertFalse(auto.tienePenalizaciones());

        jugador.mover(new Posicion(1, 0), mapa);
        assertFalse(auto.tienePenalizaciones());

        jugador.mover(new Posicion(1, 0), mapa);
        assertFalse(auto.tienePenalizaciones());
    }

    @Test
    public void unCuatroXCuatroSePosicionaSobreUnObstaculoNuloYNoRecibePenalizacion() {
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        Jugador jugador = new Jugador(new Posicion(0, 0), cuatroXCuatro);
        Mapa mapa = new Mapa(10, 10);

        jugador.mover(new Posicion(1, 0), mapa);
        assertFalse(cuatroXCuatro.tienePenalizaciones());

        jugador.mover(new Posicion(1, 0), mapa);
        assertFalse(cuatroXCuatro.tienePenalizaciones());

        jugador.mover(new Posicion(1, 0), mapa);
        assertFalse(cuatroXCuatro.tienePenalizaciones());
    }
}
