package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.juego.VistaTablero;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class VistaJuego {
    public final static double FACTOR_ESCALA = 100;

    private ControladorJuego controlador;
    private ModeloJuego modelo;

    private BorderPane nodoRaiz;
    private VistaJugador vistaJugador;
    private VistaMapa vistaMapa;

    public VistaJuego(ControladorJuego controlador, ModeloJuego modelo) {
        this.nodoRaiz = new BorderPane();
        this.controlador = controlador;
        this.modelo = modelo;
        this.vistaMapa = new VistaMapa(this.modelo.getMapa());
        this.vistaJugador = new VistaJugador(this.modelo.getJugador());
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.nodoRaiz.setCenter(new VistaTablero(this.vistaJugador, this.vistaMapa));
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
