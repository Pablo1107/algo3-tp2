package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import javafx.scene.input.KeyEvent;

public class ControladorJuego {
    private ModeloJuego modelo;
    private static final Direccion DIR_DERECHA = new Direccion(1, 0);
    private static final Direccion DIR_IZQUIERDA = new Direccion(-1, 0);
    private static final Direccion DIR_ARRIBA = new Direccion(-1, 0);
    private static final Direccion DIR_ABAJO = new Direccion(1, 0);

    public ControladorJuego(ModeloJuego modelo) {
        this.modelo = modelo;
    }

    public void mover(KeyEvent evento) {
        switch (evento.getCode()) {
            case RIGHT:
                this.moverDerecha();
                break;
            case LEFT:
                this.moverIzquierda();
                break;
            case UP:
                this.moverArriba();
                break;
            case DOWN:
                this.moverAbajo();
                break;
            default:
                break;
        }
    }

    private void moverDerecha() {
        this.modelo.turno(DIR_DERECHA);
    }

    private void moverIzquierda() {
        this.modelo.turno(DIR_IZQUIERDA);
    }

    private void moverArriba() {
        this.modelo.turno(DIR_ARRIBA);
    }

    private void moverAbajo() {
        this.modelo.turno(DIR_ABAJO);
    }
}
