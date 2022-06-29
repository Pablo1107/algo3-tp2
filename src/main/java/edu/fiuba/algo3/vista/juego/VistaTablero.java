package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.vista.VistaVehiculoJugador;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class VistaTablero extends StackPane {
    private VistaVehiculoJugador vistaJugador;
    private VistaMapa vistaMapa;

    public VistaTablero(VistaVehiculoJugador vistaJugador, VistaMapa vistaMapa) {
        this.vistaJugador = vistaJugador;
        this.vistaMapa = vistaMapa;
        this.setId("contenedor-tablero");

        Pane pane = new Pane(this.vistaMapa, this.vistaJugador);
        pane.setId("tablero");
        this.getChildren().add(pane);
    }
}
