package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.controlador.ControladorTecladoJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class VistaPantallaJuego extends HBox {
    public final static double FACTOR_ESCALA_PX = 100;

    private ControladorTecladoJuego controladorTeclado;
    private ControladorCambioDePantallas controladorCambioPantallas;

    private ModeloJuego modelo;
    private VistaVehiculoJugador vistaJugador;
    private VistaMapa vistaMapa;
    private VistaOculta vistaOculta;

    public VistaPantallaJuego(ModeloJuego modelo, ControladorCambioDePantallas controladorCambioPantallas) {
        this.modelo = modelo;
        this.controladorTeclado = new ControladorTecladoJuego(this.modelo);
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.vistaMapa = new VistaMapa(this.modelo.getMapa());
        this.vistaJugador = new VistaVehiculoJugador(this.modelo.getJugador());
        this.vistaOculta = new VistaOculta(this.modelo.getJugador(), this.modelo.getMapa(), this.modelo.getPosicionMeta());
        this.inicializarVista();
    }

    private void inicializarVista() {
        VistaTableroJuego tablero = new VistaTableroJuego(this.vistaJugador, this.vistaMapa, this.vistaOculta);
        this.getChildren().add(new Pane(tablero));

        VistaControlesLaterales controlesLaterales = new VistaControlesLaterales(this.controladorCambioPantallas);
        HBox.setHgrow(controlesLaterales, Priority.ALWAYS);
        this.getChildren().add(controlesLaterales);
    }

    public void inicializarMovimiento(Scene scene) {
        scene.setOnKeyPressed(evento -> {
            this.controladorTeclado.mover(evento);
            this.actualizar();

            if (this.modelo.getJuegoTerminado()) {
                this.controladorCambioPantallas.cargarPantallaNombres();
            }
        });
    }

    public void actualizar() {
        this.vistaJugador.actualizarVista();
        this.vistaOculta.actualizarVista();
    }
}
