package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.ayuda.VistaAyuda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
        VistaAyuda root = new VistaAyuda();
        Scene scene = new Scene(root.asParent(), 1250, 750);
        root.volver(this.stage);
        stage.setScene(scene);
    }
}
