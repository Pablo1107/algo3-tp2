package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.input.KeyEvent;

public class Controlador {
    private Jugador jugador;

    public Controlador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void teclaPresionada(KeyEvent event) {
        switch(event.getCode()) {
            case UP:
                this.moverArriba();
                break;
            case DOWN: 
                this.moverAbajo();
                break;
            case RIGHT: 
                this.moverDerecha();
                break;
            case LEFT: 
                this.moverIzquierda();
                break;
            default:
                break;
        }
    }

    private void moverArriba() {
//        this.jugador.avanzar(new Posicion(0, 1));
    }

    private void moverAbajo() {
//        this.jugador.avanzar(new Posicion(0, -1));
    }

    private void moverDerecha() {
//        this.jugador.avanzar(new Posicion(1, 0));
    }

    private void moverIzquierda() {
//        this.jugador.avanzar(new Posicion(-1, 0));
    }
}
