package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.controlador.ControladorPostTurnoJugador;
import edu.fiuba.algo3.controlador.ControladorTecladoJuego;
import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class VistaPantallaJuego extends HBox {
    public final static double FACTOR_ESCALA_PX = 100;

    private ControladorTecladoJuego controladorTeclado;
    private ControladorCambioDePantallas controladorCambioPantallas;
    private ControladorPostTurnoJugador controladorPostTurnoJugador;

    private VistaPartida vistaPartida;
    private VistaPanelLateralJuego vistaPanelLateralJuego;

    public VistaPantallaJuego(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorTeclado = new ControladorTecladoJuego();
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.controladorPostTurnoJugador = new ControladorPostTurnoJugador(this.controladorCambioPantallas);

        this.vistaPanelLateralJuego = new VistaPanelLateralJuego(this.controladorCambioPantallas);

        this.generarVistaPartida();
    }

    private void generarVistaPartida() {
        this.vistaPartida = new VistaPartida();
        this.getChildren().add(new Pane(this.vistaPartida));

        HBox.setHgrow(this.vistaPanelLateralJuego, Priority.ALWAYS);
        this.getChildren().add(this.vistaPanelLateralJuego);
    }

    public void iniciarEventLoop(Scene scene) {
        scene.setOnKeyPressed(evento -> {
            this.controladorTeclado.mover(evento);
            this.controladorPostTurnoJugador.actualizarVista(this.vistaPartida, this.vistaPanelLateralJuego);
            this.controladorPostTurnoJugador.finalizarTurno();
        });
    }
}
