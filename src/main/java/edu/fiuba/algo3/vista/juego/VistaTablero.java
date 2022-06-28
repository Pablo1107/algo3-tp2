package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.vista.VistaJugador;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class VistaTablero extends StackPane {
    private VistaJugador vistaJugador;
    private VistaMapa vistaMapa;

    public VistaTablero(VistaJugador vistaJugador, VistaMapa vistaMapa) {
        this.vistaJugador = vistaJugador;
        this.vistaMapa = vistaMapa;

        this.setStyle("-fx-background-color: red;");
        this.setMinSize(50, 50);
        /* Pane pane = new Pane(this.vistaMapa, this.vistaJugador);
        pane.setStyle("-fx-background-color: red;");
        this.getChildren().add(pane); */
    }
}
