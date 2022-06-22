package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class VistaJuego {
    private ControladorJuego controlador;
    private ModeloJuego modelo;

    public final static double FACTOR_ESCALA = 10;
    private Group vista;
    private VistaJugador vistaJugador;
    private VistaMapa vistaMapa;

    public VistaJuego(ControladorJuego controlador, ModeloJuego modelo) {
        this.controlador = controlador;
        this.modelo = modelo;

        this.vista = new Group();

        this.vistaMapa = VistaMapa.crear(this.modelo.getMapa());
        this.vistaJugador = VistaJugador.crear(this.modelo.getJugador());

        this.vista.getChildren().add(this.vistaMapa);
        this.vista.getChildren().add(this.vistaJugador);
    }

    public Parent asParent() {
        return this.vista;
    }

    public void inicializarMovimiento(Scene scene) {
        scene.setOnKeyPressed(evento -> {
            this.controlador.mover(evento);
            this.vistaJugador.actualizarPosicion();
        });
    }
}
