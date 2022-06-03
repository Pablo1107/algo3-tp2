package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest {

    @Test
    public void unaMotoSeMuevePisaPozo() {
        Ciudad ciudad = new Ciudad();
        Jugador jugador = new Jugador(ciudad);
        Pozo pozo = new Pozo();

        assertEquals(0, jugador.getVehiculo().getPenalizaciones());

        ciudad.agregarObstaculo(pozo, 1, 0);
        jugador.mover("derecha");

        assertEquals(3, jugador.getVehiculo().getPenalizaciones());

        jugador.mover("derecha");
        assertEquals(2, jugador.getVehiculo().getPenalizaciones());

        jugador.mover("derecha");
        assertEquals(1, jugador.getVehiculo().getPenalizaciones());

        jugador.mover("derecha");
        assertEquals(0, jugador.getVehiculo().getPenalizaciones());
    }
}
