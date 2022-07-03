package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.ElementoNulo;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class JugadorYElementoNulo {
    @Test
    public void laPenalizacionDeUnElementoNuloParaUnJugadorConUnaMotoEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ElementoNulo elementoNulo = new ElementoNulo(posicion);
        Moto moto = new Moto();
        Jugador jugador = new Jugador(posicion, moto);

        elementoNulo.chocarCon(jugador);

        assertFalse(moto.tienePenalizaciones());
    }

    @Test
    public void laPenalizacionDeUnElementoNuloParaUnJugadorConUnAutoEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ElementoNulo elementoNulo = new ElementoNulo(posicion);
        Auto auto = new Auto();
        Jugador jugador = new Jugador(posicion, auto);

        elementoNulo.chocarCon(jugador);

        assertFalse(auto.tienePenalizaciones());
    }

    @Test
    public void laPenalizacionDeUnElementoNuloParaUnJugadorConUnCuatroXCuatroEsCero() {
        Posicion posicion = new Posicion(0, 0);
        ElementoNulo elementoNulo = new ElementoNulo(posicion);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        Jugador jugador = new Jugador(posicion, cuatroXCuatro);

        elementoNulo.chocarCon(jugador);

        assertFalse(cuatroXCuatro.tienePenalizaciones());
    }
}

