package edu.fiuba.algo3.vista.pantallas;

import edu.fiuba.algo3.controlador.ControladorBotonCerrarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonReiniciarJuego;
import edu.fiuba.algo3.controlador.ControladorCambioPantallas;
import edu.fiuba.algo3.controlador.ControladorTecladoJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaMapa;
import edu.fiuba.algo3.vista.VistaVehiculoJugador;
import edu.fiuba.algo3.vista.juego.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPantallaJuego extends BorderPane {
    public final static double FACTOR_ESCALA = 100;

    private Stage stage;

    private ControladorTecladoJuego controlador;
    private ModeloJuego modelo;

    private VistaVehiculoJugador vistaJugador;
    private VistaMapa vistaMapa;
    private ControladorCambioPantallas controladorCambioPantallas;

    public VistaPantallaJuego(ModeloJuego modelo, ControladorCambioPantallas controladorCambioPantallas) {
        this.modelo = modelo;
        this.controladorCambioPantallas = controladorCambioPantallas;

        this.vistaMapa = new VistaMapa(this.modelo.getMapa());
        this.vistaJugador = new VistaVehiculoJugador(this.modelo.getJugador());
        this.inicializarVista();
    }

    private void inicializarVista() {
        VistaTablero tablero = new VistaTablero(this.vistaJugador, this.vistaMapa);
        Pane wrapperTablero = new Pane(tablero);
        this.setCenter(wrapperTablero);

        // Button reiniciar = this.horrible("Reiniciar", new ControladorBotonReiniciarJuego(this.modelo, this.stage));
        // Button salir = this.horrible("Salir", new ControladorBotonCerrarJuego());
        // VBox group = new VBox(reiniciar, salir);
        // this.setRight(group);
    }

    public void inicializarMovimiento(Scene scene) {
        scene.setOnKeyPressed(evento -> {
            this.controlador.mover(evento);
            this.actualizar();
            this.controlador.terminoJuego();//Verifica si se termino el juego
        });
    }

    public void actualizar() {
        this.vistaJugador.actualizarVista();
    }

}
