package edu.fiuba.algo3.vista.partidas;

import java.util.List;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.layout.VBox;

public class VistaListadoPartidas extends VBox {
    public VistaListadoPartidas() {
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("contendor-listado-partidas");

        List<Partida> partidas = ModeloJuego.getInstancia().getPartidas();
        for (Partida partida : partidas) {
            this.getChildren().add(new VistaEntradaPartida(partida));
        }
    }
}
