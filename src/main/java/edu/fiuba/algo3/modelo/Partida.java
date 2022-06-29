package edu.fiuba.algo3.modelo;

import java.time.LocalDateTime;

public class Partida {
    private final int puntaje;
    private final LocalDateTime horaRegistro;

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
}
