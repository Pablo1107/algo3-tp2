package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void moverJugador() {
        Ciudad ciudad = new Ciudad();
        Jugador jugador = new Jugador(ciudad);

        int iPosInicial = jugador.iPos;
        int jPosInicial = jugador.jPos;

        jugador.mover("derecha");

        assertEquals(iPosInicial + 1, jugador.iPos);
        assertEquals(jPosInicial, jugador.jPos);

        jugador.mover("izquierda");

        assertEquals(iPosInicial, jugador.iPos);
        assertEquals(jPosInicial, jugador.jPos);

        jugador.mover("abajo");

        assertEquals(iPosInicial, jugador.iPos);
        assertEquals(jPosInicial + 1, jugador.jPos);

        jugador.mover("arriba");

        assertEquals(iPosInicial, jugador.iPos);
        assertEquals(jPosInicial, jugador.jPos);

        jugador.mover("izquierda");

        assertEquals(iPosInicial, jugador.iPos);
        assertEquals(jPosInicial, jugador.jPos);

        jugador.mover("arriba");

        assertEquals(iPosInicial, jugador.iPos);
        assertEquals(jPosInicial, jugador.jPos);

        jugador.mover("direccion-no-existente");

        assertEquals(iPosInicial, jugador.iPos);
        assertEquals(jPosInicial, jugador.jPos);
    }
}


