package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ModeloJuego {
    private static final Posicion POS_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();

    private static final int MAPA_LIMITE_X = 10;
    private static final int MAPA_LIMITE_Y = 10;

    private final Jugador jugador;
    private final Mapa mapa;

    public ModeloJuego() {
        this.jugador = new Jugador(POS_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
        this.mapa = new Mapa(MAPA_LIMITE_X, MAPA_LIMITE_Y);
        this.inicializarJuego();
    }

    private void inicializarJuego() {
        // Aqui vendria bien usar un factory por si queremos tener diferentes
        // algoritmos de generacion de obstaculos y eso. Por el momento pues
        // voy a poner Pozos en lugares random.
        
        for (int i = 0; i < 10; i++) {
            int xRandom = (int)Math.floor(Math.random() * this.mapa.getLimiteX());
            int yRandom = (int)Math.floor(Math.random() * this.mapa.getLimiteY());
            Posicion posicion = new Posicion(xRandom, yRandom);
            Pozo pozo = new Pozo(posicion);
            this.mapa.agregarElemento(pozo);
        }
    }

    public void turno(Direccion direccion) {
        this.jugador.avanzar(direccion, this.mapa);
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public Mapa getMapa() {
        return this.mapa;
    }
}
