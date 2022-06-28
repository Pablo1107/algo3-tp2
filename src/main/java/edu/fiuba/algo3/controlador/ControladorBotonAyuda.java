package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.ayuda.VistaAyuda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonAyuda implements EventHandler<ActionEvent> {
    private Stage stage;

    public ControladorBotonAyuda(Stage stage) {
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
