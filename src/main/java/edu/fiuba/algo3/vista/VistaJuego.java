package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class VistaJuego {
    public final static double FACTOR_ESCALA = 100;

    private ControladorJuego controlador;
    private ModeloJuego modelo;

    private Group root;
    private VistaJugador vistaJugador;
    private VistaMapa vistaMapa;

    public VistaJuego(ControladorJuego controlador, ModeloJuego modelo) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.root = new Group();

        this.vistaMapa = new VistaMapa(this.modelo.getMapa());
        this.vistaJugador = new VistaJugador(this.modelo.getJugador());

        this.inicializarVista();
    }

    private void inicializarVista() {
        this.root.getChildren().add(this.vistaMapa);
        this.root.getChildren().add(this.vistaJugador);

        // Esto es solo para probar el cambio de vehiculo mientras no ponemos
        // los obstaculos.
        Button button = new Button("CAMBIAR VEHICULO");
        button.setOnAction(event -> {
            this.modelo.getJugador().cambiarVehiculo();
            this.vistaJugador.actualizarPosicion();
        });
        this.root.getChildren().add(button);
    }

    public Parent asParent() {
        return this.root;
    }

    public void inicializarMovimiento(Scene scene) {
        // Basicamente cada tick de nuestro event loop va a estar determinado
        // por cuando el jugador avance. No va a pasar nada mientras el jugador
        // no avance, asi que no es necesario mantener otro event loop.
        scene.setOnKeyPressed(evento -> {
            this.controlador.mover(evento);
            this.actualizar();
        });
    }

    private void actualizar() {
        this.vistaJugador.actualizarPosicion();
    }
}
