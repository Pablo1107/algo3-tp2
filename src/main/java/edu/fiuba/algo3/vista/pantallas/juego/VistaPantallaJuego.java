package edu.fiuba.algo3.vista.pantallas.juego;

import edu.fiuba.algo3.controlador.ControladorBotonReiniciarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonVolver;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.controlador.ControladorTecladoJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaMapa;
import edu.fiuba.algo3.vista.VistaVehiculoJugador;
import edu.fiuba.algo3.vista.juego.VistaTableroJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class VistaPantallaJuego extends BorderPane {
    public final static double FACTOR_ESCALA = 100;

    private ControladorTecladoJuego controladorTeclado;
    private ControladorCambioDePantallas controladorCambioPantallas;

    private ModeloJuego modelo;
    private VistaVehiculoJugador vistaJugador;
    private VistaMapa vistaMapa;

    public VistaPantallaJuego(ModeloJuego modelo, ControladorCambioDePantallas controladorCambioPantallas) {
        this.modelo = modelo;
        this.controladorTeclado = new ControladorTecladoJuego(this.modelo);
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.vistaMapa = new VistaMapa(this.modelo.getMapa());
        this.vistaJugador = new VistaVehiculoJugador(this.modelo.getJugador());
        this.inicializarVista();
    }

    private void inicializarVista() {
        VistaTableroJuego tablero = new VistaTableroJuego(this.vistaJugador, this.vistaMapa);
        this.setCenter(new Pane(tablero));

        Button reiniciar = this.crearBotonConControlador("Reiniciar", new ControladorBotonReiniciarJuego(this.controladorCambioPantallas));
        Button salir = this.crearBotonConControlador("Volver", new ControladorBotonVolver(this.controladorCambioPantallas));
        VBox botonesLaterales = new VBox(reiniciar, salir);
        botonesLaterales.setId("contenedor-botones-laterales");
        this.setRight(botonesLaterales);
    }

    public void inicializarMovimiento(Scene scene) {
        scene.setOnKeyPressed(evento -> {
            this.controladorTeclado.mover(evento);
            this.actualizar();
            this.controladorTeclado.terminoJuego();
        });
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }

    public void actualizar() {
        this.vistaJugador.actualizarVista();
    }
}
