package edu.fiuba.algo3.vista.partidas;

import javafx.scene.layout.VBox;

public class VistaListadoResultados extends VBox {
    public VistaListadoResultados() {
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("lista-vertical");

        // List<Partida> partidas = ModeloJuego.getInstancia().getPartidas();
        // for (Partida partida : partidas) {
        //     this.getChildren().add(new VistaEntradaPartida(partida));
        // }
    }
}
