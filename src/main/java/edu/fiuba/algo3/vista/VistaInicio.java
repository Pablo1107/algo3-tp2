package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaInicio {
    private VBox vbox;
    private final int anchoBotones;
    private final String colorLetraBoton;
    private final String colorFondoBoton;
    private final String colorBordeBoton;
    private final String anchoBordeBoton;
    private final Font fuente;
    private final double largoFuente;
    private final double espaciado;

    private Button unJugadorBoton;
    private Button multiJugadorBoton;
    private Button arcadeBoton;
    private Button puntajesBoton;
    private Button ayudaBoton;
    private Button idiomaBoton;
    private Button cerrarBoton;


    public VistaInicio() {
        this.vbox = new VBox();
        this.anchoBotones = 600;
        this.colorLetraBoton = "-fx-text-fill: #212FE3";
        this. colorFondoBoton = "-fx-background-color: #E1E1E1";
        this.colorBordeBoton = "-fx-border-color: #566573";
        this.anchoBordeBoton = "-fx-border-width: 1px";
        this.largoFuente = 14;
        this.fuente = new Font("Courier New", this.largoFuente);
        this.espaciado = 10;

        this.unJugadorBoton = new Button();
        this.multiJugadorBoton = new Button();
        this.arcadeBoton = new Button();
        this.puntajesBoton = new Button();
        this.ayudaBoton = new Button();
        this.idiomaBoton = new Button();
        this.cerrarBoton = new Button();

        this.inicializarVista();
    }

    private void inicializarVista() {

        this.vbox.setAlignment(Pos.CENTER);
        this.vbox.setSpacing(this.espaciado);

        this.setBoton(this.unJugadorBoton, "Un Jugador");
        this.setBoton(this.multiJugadorBoton, "Multijugador");
        this.setBoton(this.arcadeBoton, "Arcade");
        this.setBoton(this.puntajesBoton, "Puntajes Maximos");
        this.setBoton(this.ayudaBoton, "Ayuda");
        this.setBoton(this.idiomaBoton, "Idioma");
        this.setBoton(this.cerrarBoton, "Salir");

    }

    private void setBoton(Button boton, String texto) {
        boton.setText(texto);
        boton.setPrefWidth(this.anchoBotones);
        boton.setStyle(this.colorLetraBoton);
        boton.setStyle(this. colorFondoBoton);
        boton.setStyle(this.colorBordeBoton);
        boton.setStyle(this.anchoBordeBoton);
        boton.setFont(this.fuente);
        this.vbox.getChildren().add(boton);
    }

    public Parent asParent() {
        return this.vbox;
    }

    public void presionarBotones(Stage stage) {
        ControladorEventoUnJugador eventoUnJugador = new ControladorEventoUnJugador(this.unJugadorBoton, stage);
        this.unJugadorBoton.setOnAction(eventoUnJugador);

        ControladorEventoMultiJugador eventoMultiJugador = new ControladorEventoMultiJugador(this.multiJugadorBoton, stage);
        this.multiJugadorBoton.setOnAction(eventoMultiJugador);

        ControladorEventoArcade eventoArcade = new ControladorEventoArcade(this.arcadeBoton, stage);
        this.arcadeBoton.setOnAction(eventoArcade);

        ControladorEventoPuntajes eventoPuntajes = new ControladorEventoPuntajes(this.puntajesBoton, stage);
        this.puntajesBoton.setOnAction(eventoPuntajes);

        ControladorEventoIdioma eventoIdioma = new ControladorEventoIdioma(this.idiomaBoton, stage);
        this.idiomaBoton.setOnAction(eventoIdioma);

        ControladorEventoAyuda eventoAyuda = new ControladorEventoAyuda(this.ayudaBoton, stage);
        this.ayudaBoton.setOnAction(eventoAyuda);

        ControladorCerrarJuego cerrar = new ControladorCerrarJuego(this.cerrarBoton);
        this.cerrarBoton.setOnAction(cerrar);
    }

}
