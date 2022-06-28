package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaJugador;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class VistaJuego {
    public final static double FACTOR_ESCALA = 100;

    private ControladorJuego controlador;
    private ModeloJuego modelo;

    private StackPane nodoRaiz;
    private VistaJugador vistaJugador;
    private VistaMapa vistaMapa;

    public VistaJuego(ControladorJuego controlador, ModeloJuego modelo) {
        this.nodoRaiz = new StackPane();
        this.controlador = controlador;
        this.modelo = modelo;
        this.vistaMapa = new VistaMapa(this.modelo.getMapa());
        this.vistaJugador = new VistaJugador(this.modelo.getJugador());
        this.inicializarVista();
    }

    private void inicializarVista() {
    }

    public Parent getNodoRaiz() {
        return this.nodoRaiz;
    }

    public void inicializarMovimiento(Scene scene) {
        scene.setOnKeyPressed(evento -> {
            this.controlador.mover(evento);
            this.actualizar();
        });
    }

    private void actualizar() {
        this.vistaJugador.actualizar();
    }
}
