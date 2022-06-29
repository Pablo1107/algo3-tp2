package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.controlador.ControladorCambioPantallas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaPantallaInicio extends VBox {
    private ControladorCambioPantallas controladorCambioPantallas;

    public VistaPantallaInicio(ControladorCambioPantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("vista-botones-inicio");

        this.agregarBotonConControlador("Iniciar Juego", new ControladorBotonIniciarJuego(this.controladorCambioPantallas));
        /* this.agregarBotonConControlador("Iniciar Multijugador", new ControladorBotonIniciarJuego(this.stage));
        this.agregarBotonConControlador("Ayuda", new ControladorBotonAyuda(this.stage));
        this.agregarBotonConControlador("Cerrar", new ControladorBotonCerrarJuego()); */
    }

    private void agregarBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        this.getChildren().add(boton);
    }
}
