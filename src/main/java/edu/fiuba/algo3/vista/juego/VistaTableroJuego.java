package edu.fiuba.algo3.vista.juego;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class VistaTableroJuego extends StackPane {
    private VistaVehiculoJugador vistaJugador;
    private VistaMapa vistaMapa;
    private VistaOculta vistaOculta;

    public VistaTableroJuego(VistaVehiculoJugador vistaJugador, VistaMapa vistaMapa, VistaOculta vistaOculta) {
        this.vistaJugador = vistaJugador;
        this.vistaMapa = vistaMapa;
        this.vistaOculta = vistaOculta;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("tablero-juego");
        this.getChildren().add(new Pane(this.vistaMapa, this.vistaJugador, this.vistaOculta));
    }
}
