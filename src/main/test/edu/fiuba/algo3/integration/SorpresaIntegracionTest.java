package edu.fiuba.algo3.integration;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.elemento.Elemento;
import edu.fiuba.algo3.modelo.mapa.elemento.sorpresa.Favorable;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaIntegracionTest {
    @Test
    public void unVehiculoAtraviesaLaCiudadYSeEncuentraUnaSorpresaFavorable() {
        Vehiculo vehiculo = new Moto();
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(new Posicion(0, 0), vehiculo);
        Elemento favorable = new Favorable(new Posicion(5, 0));
        mapa.agregarElemento(favorable);

        assertEquals(jugador.getMovimientos(), 0);

        jugador.mover(new Posicion(1, 0), mapa);
        assertEquals(jugador.getMovimientos(), 1);

        jugador.mover(new Posicion(1, 0), mapa);
        assertEquals(jugador.getMovimientos(), 2);

        jugador.mover(new Posicion(1, 0), mapa);
        assertEquals(jugador.getMovimientos(), 3);

        jugador.mover(new Posicion(1, 0), mapa);
        assertEquals(jugador.getMovimientos(), 4);

        jugador.mover(new Posicion(1, 0), mapa);
        assertEquals(jugador.getMovimientos(), 4);
    }

    @Test
    public void unVehiculoAtraviesaLaCiudadYSeEncuentraUnaSorpresaDesfavorable() {
        Vehiculo vehiculo = new Moto();
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(new Posicion(0, 0), vehiculo);
        Elemento favorable = new Favorable(new Posicion(4, 0));
        mapa.agregarElemento(favorable);

        assertEquals(jugador.getMovimientos(), 0);

        jugador.mover(new Posicion(1, 0), mapa);
        assertEquals(jugador.getMovimientos(), 1);

        jugador.mover(new Posicion(1, 0), mapa);
        assertEquals(jugador.getMovimientos(), 2);

        jugador.mover(new Posicion(1, 0), mapa);
        assertEquals(jugador.getMovimientos(), 3);

        jugador.mover(new Posicion(1, 0), mapa);
        assertEquals(jugador.getMovimientos(), 3);
    }
}
