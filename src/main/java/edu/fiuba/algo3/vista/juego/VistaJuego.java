package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.controlador.ControladorBotonCerrarJuego;
import edu.fiuba.algo3.controlador.ControladorTecladoJuego;
import edu.fiuba.algo3.controlador.ControladorBotonReiniciarJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaVehiculoJugador;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaJuego {
    public final static double FACTOR_ESCALA = 100;

    private Stage stage;

    private ControladorTecladoJuego controlador;
    private ModeloJuego modelo;

    private BorderPane nodoRaiz;
    private VistaVehiculoJugador vistaJugador;
    private VistaMapa vistaMapa;

    public VistaJuego(ControladorTecladoJuego controlador, ModeloJuego modelo, Stage stage) {
        this.nodoRaiz = new BorderPane();
        this.controlador = controlador;
        this.modelo = modelo;
        this.vistaMapa = new VistaMapa(this.modelo.getMapa());
        this.vistaJugador = new VistaVehiculoJugador(this.modelo.getJugador());
        this.stage = stage;

        this.inicializarVista();
    }

    private void inicializarVista() {
        VistaTablero tablero = new VistaTablero(this.vistaJugador, this.vistaMapa);
        Pane wrapperTablero = new Pane(tablero);
        this.nodoRaiz.setCenter(wrapperTablero);

        Button reiniciar = this.horrible("Reiniciar", new ControladorBotonReiniciarJuego(this.modelo, this.stage));
        Button salir = this.horrible("Salir", new ControladorBotonCerrarJuego());

        VBox group = new VBox(reiniciar, salir);
        this.nodoRaiz.setRight(group);
    }

    // TODO: Intentar unificar esto en todas las vistas.
    private Button horrible(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }

    public Parent getNodoRaiz() {
        return this.nodoRaiz;
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
