package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

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

    @Test
    public void seCreaUnaPartidaSeSeteaElNombreYSeVerifica() {
        Partida partida = new Partida(0);
        String nombreEsperado = "nombre";

        partida.setNombre("nombre");
        String nombreActual = partida.getNombre();

        assertEquals(nombreEsperado, nombreActual);
    }
}
