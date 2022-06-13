package edu.fiuba.algo3.modelo.mapa.elemento.sorpresa;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.elemento.Elemento;

public abstract class Sorpresa extends Elemento {
    public Sorpresa(Posicion posicion) {
        super(posicion);
    }
    //public abstract void chocarCon(Vehiculo vehiculo);

    public abstract void chocarCon(Jugador jugador);

}
