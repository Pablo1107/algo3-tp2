package edu.fiuba.algo3.casos_de_uso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class PenalizacionesPiqueteIntegracionTest {
    @Test
    public void unaMotoAtraviesaLaCiudadYSeEncuentraUnPiqueteYRecibeDosPenalizaciones() {
        Vehiculo vehiculo = new Moto();
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(new Posicion(0, 0), vehiculo);
        Elemento elemento = new Piquete(new Posicion(1, 0));
        mapa.agregarElemento(elemento);

        assertEquals(vehiculo.getPenalizaciones(), 0);

        jugador.avanzar(new Posicion(1, 0), mapa);
        assertEquals(vehiculo.getPenalizaciones(), 2);

        jugador.avanzar(new Posicion(1, 0), mapa);
        assertEquals(vehiculo.getPenalizaciones(), 1);

        jugador.avanzar(new Posicion(1, 0), mapa);
        assertEquals(vehiculo.getPenalizaciones(), 0);
    }

    @Test
    public void unAutoAtraviesaLaCiudadYSeEncuentraUnPiqueteYNoPuedeSeguirAvanzandoEnEsaPosicion() {
        Vehiculo vehiculo = new Auto();
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(new Posicion(0, 0), vehiculo);
        Elemento elemento = new Piquete(new Posicion(1, 0));
        mapa.agregarElemento(elemento);

        assertEquals(vehiculo.getPenalizaciones(), 0);

        jugador.avanzar(new Posicion(1, 0), mapa);
        assertEquals(vehiculo.getPenalizaciones(), 0);
        assertEquals(jugador.getPosicion(), new Posicion(0, 0));

        jugador.avanzar(new Posicion(1, 0), mapa);
        assertEquals(vehiculo.getPenalizaciones(), 0);
        assertEquals(jugador.getPosicion(), new Posicion(0, 0));

        jugador.avanzar(new Posicion(0, 1), mapa);
        assertEquals(vehiculo.getPenalizaciones(), 0);
        assertEquals(jugador.getPosicion(), new Posicion(0, 1));
    }

    @Test
    public void unaCuatroXCuatroAtraviesaLaCiudadYSeEncuentraUnPiqueteYNoPuedeSeguirAvanzandoEnEsaPosicion() {
        Vehiculo vehiculo = new CuatroXCuatro();
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(new Posicion(0, 0), vehiculo);
        Elemento elemento = new Piquete(new Posicion(1, 0));
        mapa.agregarElemento(elemento);

        assertEquals(vehiculo.getPenalizaciones(), 0);

        jugador.avanzar(new Posicion(1, 0), mapa);
        assertEquals(vehiculo.getPenalizaciones(), 0);
        assertEquals(jugador.getPosicion(), new Posicion(0, 0));

        jugador.avanzar(new Posicion(1, 0), mapa);
        assertEquals(vehiculo.getPenalizaciones(), 0);
        assertEquals(jugador.getPosicion(), new Posicion(0, 0));

        jugador.avanzar(new Posicion(0, 1), mapa);
        assertEquals(vehiculo.getPenalizaciones(), 0);
        assertEquals(jugador.getPosicion(), new Posicion(0, 1));
    }
}
