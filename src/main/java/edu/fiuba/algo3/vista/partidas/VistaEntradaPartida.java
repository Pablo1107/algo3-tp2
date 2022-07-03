package edu.fiuba.algo3.vista.partidas;

import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class VistaEntradaPartida extends FlowPane {
    private Partida partida; 

    public VistaEntradaPartida(Partida partida) {
        this.partida = partida;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("entrada-listado-partida");

        Text jugador = new Text("Carlos");
        Text puntaje = new Text(String.valueOf(this.partida.getPuntaje()));
        this.getChildren().add(jugador);
        this.getChildren().add(puntaje);
    }
}
