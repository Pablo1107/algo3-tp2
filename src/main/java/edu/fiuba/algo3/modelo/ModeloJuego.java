package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ModeloJuego {
    private static final Posicion POS_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();
    // TODO: Realmente las dimensiones del mapa son dinamicas.
    private static final int MAPA_LIMITE_X = 20;
    private static final int MAPA_LIMITE_Y = 20;

    private final Jugador jugador;
    private final Mapa mapa;

    public ModeloJuego() {
        this.jugador = new Jugador(POS_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
        this.mapa = new Mapa(MAPA_LIMITE_X, MAPA_LIMITE_Y);
    }

    public void turno(Direccion direccion) {
        this.jugador.avanzar(direccion, this.mapa);
    }
}
