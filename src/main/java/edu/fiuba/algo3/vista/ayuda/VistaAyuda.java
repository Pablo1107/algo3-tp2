package edu.fiuba.algo3.vista.ayuda;

import edu.fiuba.algo3.controlador.ControladorEventoVolver;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaAyuda {
    private VBox ayuda;
    private Button volver;

    public VistaAyuda() {
        this.ayuda = new VBox(100);
        this.volver = new Button("Volver");

        this.ayuda.setAlignment(Pos.CENTER);
        this.volver.setLayoutX(1200);
        this.volver.setLayoutY(700);

        Label titulo = new Label("Ayuda");

        this.ayuda.getChildren().add(titulo);
        this.ayuda.getChildren().add(new TextoAyuda());
        this.ayuda.getChildren().add(this.volver);
    }

    public Parent asParent() {
        return this.ayuda;
    }

    public void volver(Stage stage) {
        ControladorEventoVolver eventoVolver = new ControladorEventoVolver(this.volver, stage);
        this.volver.setOnAction(eventoVolver);
    }
}
