package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorTecladoJuego {
    private ModeloJuego modelo;

    private static final Direccion DIR_DERECHA = new Direccion(1, 0);
    private static final Direccion DIR_IZQUIERDA = new Direccion(-1, 0);
    private static final Direccion DIR_ARRIBA = new Direccion(0, -1);
    private static final Direccion DIR_ABAJO = new Direccion(0, 1);

    public ControladorTecladoJuego(ModeloJuego modelo) {
        this.modelo = modelo;
    }

    public void mover(KeyEvent evento) {
        KeyCode tecla = evento.getCode();
        if (tecla == KeyCode.D || tecla == KeyCode.L) {
            this.moverDerecha();
        }
        else if (tecla == KeyCode.A || tecla == KeyCode.H) {
            this.moverIzquierda();
        }
        else if (tecla == KeyCode.W || tecla == KeyCode.K) {
            this.moverArriba();
        }
        else if (tecla == KeyCode.S || tecla == KeyCode.J) {
            this.moverAbajo();
        }
    }

    private void moverDerecha() {
        this.modelo.jugarTurno(DIR_DERECHA);
    }

    private void moverIzquierda() {
        this.modelo.jugarTurno(DIR_IZQUIERDA);
    }

    private void moverArriba() {
        this.modelo.jugarTurno(DIR_ARRIBA);
    }

    private void moverAbajo() {
        this.modelo.jugarTurno(DIR_ABAJO);
    }
    //
    // public void reiniciarJuego() {
    //     this.modelo.reiniciarJuego();
    // }
    //
    // public void terminarJuego(ControladorCambioDePantallas controladorCambioDePantallas) {
    //     if(!this.modelo.getJuegoTerminado()) {
    //         return;
    //     }
    //
    //     // this.modelo.reiniciarJuego();
    // }
}
