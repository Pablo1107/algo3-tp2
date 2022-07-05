package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class VistaPartida extends StackPane {
    private VistaJugador vistaJugador; 
    private final VistaMapa vistaMapa;
    private VistaOculta vistaOculta; 
    private Jugador jugadorEnTurno;

    public VistaPartida() {
        this.setId("partida");

        Partida partidaActual = Juego.getInstancia().getPartidaActual();
        this.vistaMapa = new VistaMapa(partidaActual.getMapa());
        this.actualizarDatosJugador();

        this.renderizar();
    }

    private boolean turnoSiguienteJugador() {
        if (!Juego.getInstancia().hayPartidaEnCurso()) {
            return false;
        }

        Jugador jugadorEnTurno = Juego.getInstancia().getPartidaActual().getJugadorEnTurno();
        return !(jugadorEnTurno == this.jugadorEnTurno);
    }

    public void renderizar() {
        if (this.turnoSiguienteJugador()) {
            this.actualizarDatosJugador();
        }

        this.vistaJugador.renderizar();
        this.vistaOculta.renderizar();
        this.getChildren().add(new Pane(this.vistaMapa, this.vistaJugador, this.vistaOculta));
    }

    private void actualizarDatosJugador() {
        Partida partidaActual = Juego.getInstancia().getPartidaActual();
        this.jugadorEnTurno = partidaActual.getJugadorEnTurno();
        this.vistaJugador = new VistaJugador(this.jugadorEnTurno);
        this.vistaOculta = new VistaOculta(partidaActual);
    }
}
