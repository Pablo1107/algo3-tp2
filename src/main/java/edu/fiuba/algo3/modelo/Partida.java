package edu.fiuba.algo3.modelo;

import java.time.LocalDateTime;

public class Partida {
    private final int puntaje;
    private final LocalDateTime horaRegistro;
    private String nombre;

    public Partida(int puntaje) {
        this.puntaje = puntaje;
        this.nombre = null;
        this.horaRegistro = LocalDateTime.now();
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    public LocalDateTime getHoraRegistro() {
        return this.horaRegistro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
