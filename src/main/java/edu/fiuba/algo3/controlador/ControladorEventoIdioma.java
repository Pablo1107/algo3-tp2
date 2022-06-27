package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorEventoIdioma implements EventHandler<ActionEvent> {
    private Stage stage;

    private Button boton;

    public ControladorEventoIdioma(Button boton, Stage stage) {
        this.boton = boton;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //Cambiar idioma
        System.out.println("Cambiar idioma");
    }
}
