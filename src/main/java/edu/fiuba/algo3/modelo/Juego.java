package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    public static boolean corriendo;
    private Jugador jugador;
    private Mapa mapa;
    private List<Integer> puntuaciones;

    //private Thread gameThread;

    public Juego(Jugador jugador, Mapa mapa) {
        corriendo = false;
        this.jugador = jugador;
        this.mapa = mapa;
        this.puntuaciones = new ArrayList<>();
    }

    public void comenzarJuegoNuevo() {
        corriendo = true;
    }

    public void jugar() {
        Scanner input = new Scanner(System.in);
        while(corriendo) {
            String direccion = input.nextLine();
            //System.out.println(direccion);
            Posicion dir = this.transformar(direccion);
            //Posicion dir = new Posicion(1, 0);

            this.jugador.avanzar(dir, this.mapa);
            this.sigueCorriendo(this.mapa); //Si llego a la meta termina el juego

        }
        this.puntuaciones.add(this.jugador.getMovimientos());

        input.close();
    }

    private void sigueCorriendo(Mapa mapa) {
        corriendo = mapa.sigueCorriendo(jugador.getPosicion());
    }

    public void turno(Posicion direccion) {
        this.jugador.avanzar(direccion, this.mapa);
    }


    //Estro habria que pasarlo a Direccion o Posicion
    private Posicion transformar(String direccion) {
        if(direccion.equals("d")) {
            return new Posicion(1, 0);
        }
        if(direccion.equals("w")) {
            return new Posicion(0, 1);
        }
        if(direccion.equals("s")) {
            return new Posicion(0, -1);
        }
        if(direccion.equals("a")) {
            return new Posicion(-1, 0);
        }
        return null;
    }

}
