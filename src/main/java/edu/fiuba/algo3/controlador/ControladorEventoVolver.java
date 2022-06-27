package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaAyuda;
import edu.fiuba.algo3.vista.VistaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorEventoVolver implements EventHandler<ActionEvent> {
    private Stage stage;
    private Button boton;

    public ControladorEventoVolver(Button boton, Stage stage) {
        this.boton = boton;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaInicio root = new VistaInicio();
        Scene scene = new Scene(root.asParent(), 1250, 750);
        //System.out.println("Volver");
        root.presionarBotones(this.stage);
        stage.setScene(scene);
    }
}
