package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.vista.VistaInicio;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ControladorJuego {
    private ModeloJuego modelo;
    private Stage stage;
    private static final Direccion DIR_DERECHA = new Direccion(1, 0);
    private static final Direccion DIR_IZQUIERDA = new Direccion(-1, 0);
    private static final Direccion DIR_ARRIBA = new Direccion(0, -1);
    private static final Direccion DIR_ABAJO = new Direccion(0, 1);

    public ControladorJuego(ModeloJuego modelo, Stage stage) {
        this.modelo = modelo;
        this.stage = stage;
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

    public void terminoJuego() {
        if(modelo.terminoJuego()) {
            modelo.reiniciar();
            VistaInicio rootInicio = new VistaInicio();
            Scene scene = new Scene(rootInicio.asParent(), 1250, 750);
            rootInicio.presionarBotones(this.stage);
            stage.setScene(scene);
        }
    }
}
