package edu.fiuba.algo3.modelo.mapa.sorpresas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public abstract class Sorpresa extends Elemento {
    public Sorpresa(Posicion posicion) {
        super(posicion);
    }

    public abstract void chocarCon(Jugador jugador);
}
