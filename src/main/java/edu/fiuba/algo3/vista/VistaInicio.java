package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaInicio {
    private VBox vista;

    public VistaInicio() {
        this.vista = new VBox();
        this.vista.setId("vista-botones-inicio");
        this.inicializar();
    }

    private void agregarBoton(String contenido) {
        Button boton = new Button(contenido);
        this.vista.getChildren().add(boton);
    }

    private void inicializar() {
        this.vista.setAlignment(Pos.CENTER);

        this.agregarBoton("Un jugador");
        this.agregarBoton("Multijugador");
        this.agregarBoton("Puntajes Maximos");
        this.agregarBoton("Ayuda");
    }

    public Parent asParent() {
        return this.vista;
    }
}
