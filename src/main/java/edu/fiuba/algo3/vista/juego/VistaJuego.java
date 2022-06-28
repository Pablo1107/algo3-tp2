package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.controlador.ControladorCerrarJuego;
import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.controlador.ControladorReiniciarJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaJugador;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VistaJuego {
    public final static double FACTOR_ESCALA = 100;

    private Stage stage;

    private ControladorJuego controlador;
    private ModeloJuego modelo;

    private BorderPane nodoRaiz;
    private VistaJugador vistaJugador;
    private VistaMapa vistaMapa;
    private Button salir;
    private Button reiniciar;

    public VistaJuego(ControladorJuego controlador, ModeloJuego modelo, Stage stage) {
        this.nodoRaiz = new BorderPane();
        this.controlador = controlador;
        this.modelo = modelo;
        this.vistaMapa = new VistaMapa(this.modelo.getMapa());
        this.vistaJugador = new VistaJugador(this.modelo.getJugador());
        this.salir = new Button("Salir");
        this.reiniciar = new Button("Reiniciar");

        this.inicializarVista();
    }

    private void inicializarVista() {
        // TODO: FIX
        // this.root.getChildren().add(this.salir);
        // this.root.getChildren().add(this.reiniciar);

        this.reiniciar.setLayoutX(75);

        VistaTablero tablero = new VistaTablero(this.vistaJugador, this.vistaMapa);
        Pane wrapperTablero = new Pane(tablero);
        this.nodoRaiz.setCenter(wrapperTablero);
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

        ControladorCerrarJuego salirControlador = new ControladorCerrarJuego(this.salir);
        ControladorReiniciarJuego reiniciarControlador = new ControladorReiniciarJuego(this.reiniciar, this.modelo, this.stage);

        this.salir.setOnAction(salirControlador);
        this.reiniciar.setOnAction(reiniciarControlador);

    }

    public void actualizar() {
        this.vistaJugador.actualizar();
    }

}
