package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;

public class VistaJuego {
    private ControladorJuego controlador;
    private ModeloJuego modelo;
    private Group root;

    public VistaJuego(ControladorJuego controlador, ModeloJuego modelo) {
        this.controlador = controlador;
        this.modelo = modelo;

        Rectangle mapa = new Rectangle(50, 50);
        this.root = new Group(mapa);
    }

    public Parent asParent() {
        return this.root;
    }

    public void inicializarMovimiento() {
        this.root.setOnKeyPressed(evento -> {
            this.controlador.mover(evento);
        });
    }
}
