package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.juego.Partida;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartidaTest {
    @Test
    public void dadoUnPuntajeSeCreaUnaPartidaConElPuntajeEsperado() {
        Partida partida = new Partida(10);

        int puntajeEsperado = 10;
        int puntajeActual = partida.getPuntaje();

        assertEquals(puntajeEsperado, puntajeActual);
    }

    @Test
    public void alRegistrarUnaPartidaEstaContieneLaFechaDeRegistro() {
        Partida partida = new Partida(0);

        assertTrue(partida.getHoraRegistro() instanceof LocalDateTime);
    }
}
