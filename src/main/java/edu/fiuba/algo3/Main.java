package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Main {
    public static void main(String[] args) {

        Posicion posicionInicial = new Posicion(0, 0);
        Posicion posicionMeta = new Posicion(5, 0);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(posicionInicial, moto);
        Mapa mapa = new Mapa(10, 10);

        Elemento meta = new Meta(posicionMeta);

        mapa.agregarElemento(meta);

        Juego juego = new Juego(jugador, mapa);

        juego.comenzarJuegoNuevo();
        juego.jugar();
        //App.main(args);
    }
}
