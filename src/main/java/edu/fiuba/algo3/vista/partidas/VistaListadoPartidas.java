package edu.fiuba.algo3.vista.partidas;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.juego.Partida;
import javafx.scene.layout.VBox;

import java.util.List;

public class VistaListadoPartidas extends VBox {
    public VistaListadoPartidas() {
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("lista-vertical");

        List<Partida> partidas = ModeloJuego.getInstancia().getPartidas();
        for (Partida partida : partidas) {
            this.getChildren().add(new VistaEntradaPartida(partida));
        }
    }
}
