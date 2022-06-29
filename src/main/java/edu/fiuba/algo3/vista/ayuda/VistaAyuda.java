package edu.fiuba.algo3.vista.ayuda;

import edu.fiuba.algo3.controlador.ControladorBotonVolver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaAyuda extends VBox {
    private Stage stage;

    public VistaAyuda(Stage stage) {
        this.stage = stage;
        this.inicializarVista();
    }

    private void inicializarVista() {
        // this.agregarBotonConControlador("Volver", new ControladorBotonVolver(this.stage));
    }

    private void agregarBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        this.getChildren().add(boton);
    }
}
