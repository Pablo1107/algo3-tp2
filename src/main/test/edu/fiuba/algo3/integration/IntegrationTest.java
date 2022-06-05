package edu.fiuba.algo3.integration;

import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    @Test
    public void unaMotoSeMuevePisaPozo() {
        Mapa mapa = new Mapa(10, 10);
        Moto moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(0,0), moto);
        Pozo pozo = new Pozo();
        Direccion derecha = new Direccion(1,0);

        assertEquals(0, jugador.getPenalizaciones());

        mapa.setElementoEnPosicion(pozo, new Posicion(1,0));
        jugador.mover(derecha, mapa);

        assertEquals(3, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(2, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(1, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(0, jugador.getPenalizaciones());
    }

    @Test
    public void unAutoSeMuevePisaPozo() {
        Mapa mapa = new Mapa(10, 10);
        Auto auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(0,0), auto);
        Pozo pozo = new Pozo();
        Direccion derecha = new Direccion(1,0);

        assertEquals(0, jugador.getPenalizaciones());

        mapa.setElementoEnPosicion(pozo, new Posicion(1,0));
        jugador.mover(derecha, mapa);

        assertEquals(3, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(2, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(1, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(0, jugador.getPenalizaciones());
    }

    @Test
    public void unaCuatroXCutroAtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        Jugador jugador = new Jugador(new Posicion(0,0), cuatroXCuatro);
        Pozo pozo = new Pozo();
        Direccion derecha = new Direccion(1,0);

        assertEquals(0, jugador.getPenalizaciones());

        mapa.setElementoEnPosicion(pozo, new Posicion(1,0));
        jugador.mover(derecha, mapa);

        assertEquals(0, jugador.getPenalizaciones());
    }
}
