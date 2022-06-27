package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorEventoAyuda implements EventHandler<ActionEvent> {
    private Stage stage;

    private Button boton;

    public ControladorEventoAyuda(Button boton, Stage stage) {
        this.boton = boton;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //Cambiar idioma
        System.out.println("Ayuda");
    }
}
