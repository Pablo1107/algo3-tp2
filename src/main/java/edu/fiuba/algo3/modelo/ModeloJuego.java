package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ModeloJuego {
    private static final Posicion POS_INICIAL_JUGADOR = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL_JUGADOR = new Moto();
    private static final int MAPA_LIMITE_X = 15;
    private static final int MAPA_LIMITE_Y = 10;

    private static ModeloJuego instancia;

    private Jugador jugador;
    private Mapa mapa;
    private boolean juegoTerminado;

    private ModeloJuego() {
        this.jugador = new Jugador(POS_INICIAL_JUGADOR, VEHICULO_INICIAL_JUGADOR);
        this.mapa = new Mapa(MAPA_LIMITE_X, MAPA_LIMITE_Y);
        this.juegoTerminado = false;
        this.inicializarJuego();
    }

    public static ModeloJuego getInstancia() {
        if (ModeloJuego.instancia == null) {
            instancia = new ModeloJuego();
        }

        return ModeloJuego.instancia;
    }

    private void inicializarJuego() {
        double proporcionObstaculos = 0.25;
        int cantidadElementos = (int)((this.mapa.getLimiteX() * this.mapa.getLimiteY()) * proporcionObstaculos);

        for (int i = 0; i < cantidadElementos; i++) {
            Posicion posicion = this.generarPosicionRandom();
            this.mapa.agregarElemento(this.generarObstaculoRandom(posicion));
        }

        this.mapa.agregarElemento(new Meta(new Posicion(MAPA_LIMITE_X - 1, (MAPA_LIMITE_Y - 1)/2)));
    }

    public void reiniciarJuego() {
        instancia.juegoTerminado = false;
        instancia = new ModeloJuego();
    }

    public void terminarJuego() {
        instancia.juegoTerminado = true;
    }

    public void jugarTurno(Direccion direccion) {
        if (instancia.juegoTerminado) {
            return;
        }

        this.jugador.avanzar(direccion, this.mapa);
    }

    private Posicion generarPosicionRandom() {
        int coordenadaX = (int)Math.floor(Math.random() * (this.mapa.getLimiteX() - 1));
        int coordenadaY = (int)Math.floor(Math.random() * this.mapa.getLimiteY());

        return new Posicion(coordenadaX, coordenadaY);
    }

    private Obstaculo generarObstaculoRandom(Posicion posicion) {
        double random = Math.random();
        if (random < 0.3) {
            return new Pozo(posicion);
        }

        if (random < 0.7) {
            return new Piquete(posicion);
        } 

        return new ControlPolicial(posicion);
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public Mapa getMapa() {
        return this.mapa;
    }

    public boolean getJuegoTerminado() {
        return instancia.juegoTerminado;
    }
}
