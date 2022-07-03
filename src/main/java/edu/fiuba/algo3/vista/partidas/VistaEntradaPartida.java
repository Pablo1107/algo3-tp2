package edu.fiuba.algo3.vista.partidas;

import edu.fiuba.algo3.modelo.juego.Partida;
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

        String nombreJugador = "Carlos";
        int puntajePartida = this.partida.getPuntaje();

        String formato = String.format("%s: %s Movimientos", nombreJugador, puntajePartida);

        this.getChildren().add(new Text(formato));
    }
}
