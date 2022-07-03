package edu.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ContenedorBotones extends VBox {
    public ContenedorBotones() {
        this.getStyleClass().add("lista-vertical");
    }

    public void agregarBoton(Button boton) {
        this.getChildren().add(boton);
    }
}
