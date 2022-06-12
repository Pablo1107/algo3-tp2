package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public abstract class Elemento {
    protected Posicion posicion;

    public boolean estaDentroDelMapa(Mapa mapa) {
        return this.posicion.estaDentroDelMapa(mapa);
    }

    public abstract void chocarCon(Jugador jugador);
}
