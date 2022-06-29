package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.vista.VistaVehiculoJugador;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class VistaTableroJuego extends StackPane {
    private VistaVehiculoJugador vistaJugador;
    private VistaMapa vistaMapa;

    public VistaTableroJuego(VistaVehiculoJugador vistaJugador, VistaMapa vistaMapa) {
        this.vistaJugador = vistaJugador;
        this.vistaMapa = vistaMapa;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("tablero-juego");
        this.getChildren().add(new Pane(this.vistaMapa, this.vistaJugador));
    }
}
