package edu.fiuba.algo3.modelo.juego;

import java.time.LocalDateTime;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Partida {
    private final int puntaje;
    private final LocalDateTime horaRegistro;

    private List<Jugador> jugadores;

    public Partida(int puntaje) {
        this.puntaje = puntaje;
        this.horaRegistro = LocalDateTime.now();
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    public LocalDateTime getHoraRegistro() {
        return this.horaRegistro;
    }

    public void jugarTurno() {

    }
}
