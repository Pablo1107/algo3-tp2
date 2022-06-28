package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorReiniciarJuego implements EventHandler<ActionEvent> {

    private ModeloJuego modelo;
    private Stage stage;
    private Button boton;
    public ControladorReiniciarJuego(Button reiniciarBoton, ModeloJuego modelo, Stage stage) {
        this.boton = reiniciarBoton;
        this.modelo = modelo;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.modelo.reiniciar();

        ControladorJuego controlador = new ControladorJuego(this.modelo, this.stage);
        VistaJuego root = new VistaJuego(controlador, this.modelo, this.stage);
        Scene scene = new Scene(root.asParent());
        root.inicializarMovimiento(scene);
        stage.setScene(scene);

    }
}
