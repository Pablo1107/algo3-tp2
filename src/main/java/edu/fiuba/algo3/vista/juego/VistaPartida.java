package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Partida;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class VistaPartida extends StackPane {
    private VistaJugador vistaJugador; 
    private VistaMapa vistaMapa; 
    private VistaOculta vistaOculta; 

    public VistaPartida() {
        this.setId("tablero-juego");

        Partida partidaActual = Juego.getInstancia().getPartidaActual();
        this.vistaJugador = new VistaJugador(partidaActual.getJugador());
        this.vistaMapa = new VistaMapa(partidaActual.getMapa());
        this.vistaOculta = new VistaOculta(partidaActual);

        this.renderizar();
    }

    public void renderizar() {
        this.vistaJugador.renderizar();
        this.vistaOculta.renderizar();
        this.getChildren().add(new Pane(this.vistaMapa, this.vistaJugador, this.vistaOculta));
    }
}
