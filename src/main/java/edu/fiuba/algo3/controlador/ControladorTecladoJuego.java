package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorTecladoJuego {
    private static final Direccion DIR_DERECHA = new Direccion(1, 0);
    private static final Direccion DIR_IZQUIERDA = new Direccion(-1, 0);
    private static final Direccion DIR_ARRIBA = new Direccion(0, -1);
    private static final Direccion DIR_ABAJO = new Direccion(0, 1);

    public void mover(KeyEvent evento) {
        KeyCode tecla = evento.getCode();
        if (tecla == KeyCode.D || tecla == KeyCode.L) {
            this.moverDerecha();
        } else if (tecla == KeyCode.A || tecla == KeyCode.H) {
            this.moverIzquierda();
        } else if (tecla == KeyCode.W || tecla == KeyCode.K) {
            this.moverArriba();
        } else if (tecla == KeyCode.S || tecla == KeyCode.J) {
            this.moverAbajo();
        }
    }

    private void moverDerecha() {
        ModeloJuego.getInstancia().jugarTurno(DIR_DERECHA);
    }

    private void moverIzquierda() {
        ModeloJuego.getInstancia().jugarTurno(DIR_IZQUIERDA);
    }

    private void moverArriba() {
        ModeloJuego.getInstancia().jugarTurno(DIR_ARRIBA);
    }

    private void moverAbajo() {
        ModeloJuego.getInstancia().jugarTurno(DIR_ABAJO);
    }

}
