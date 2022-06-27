package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorEventoMultiJugador implements EventHandler<ActionEvent> {
    private Button boton;
    private Stage stage;

    public ControladorEventoMultiJugador(Button boton, Stage stage) {
        this.boton = boton;
        this.stage = stage;
    }

    //Hay que hacer dos turnos
    @Override
    public void handle(ActionEvent actionEvent) {
        ModeloJuego modelo = ModeloJuego.crear();
        ControladorJuego controlador = new ControladorJuego(modelo, this.stage);
        VistaJuego root = new VistaJuego(controlador, modelo);
        Scene scene = new Scene(root.asParent());
        root.inicializarMovimiento(scene);
        stage.setScene(scene);
    }
}
