package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonCerrarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonAyuda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicio {
    private VBox nodoRaiz;
    Stage stage;

    public VistaInicio(Stage stage) {
        this.nodoRaiz = new VBox();
        this.nodoRaiz.setId("vista-botones-inicio");
        this.stage = stage;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.nodoRaiz.setAlignment(Pos.CENTER);

        this.agregarBotonConControlador("Iniciar Juego", new ControladorBotonIniciarJuego(this.stage));
        this.agregarBotonConControlador("Iniciar Multijugador", new ControladorBotonIniciarJuego(this.stage));
        // this.agregarBotonConControlador("Puntajes", new ControladorEventoPuntajes(this.stage));
        this.agregarBotonConControlador("Ayuda", new ControladorBotonAyuda(this.stage));
        this.agregarBotonConControlador("Cerrar", new ControladorBotonCerrarJuego());
    }

    private void agregarBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        this.nodoRaiz.getChildren().add(boton);
    }

    public Parent getNodoRaiz() {
        return this.nodoRaiz;
    }
}
