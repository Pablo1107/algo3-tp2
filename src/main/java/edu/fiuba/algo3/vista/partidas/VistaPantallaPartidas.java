package edu.fiuba.algo3.vista.partidas;

import edu.fiuba.algo3.controlador.ControladorBotonReiniciarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonVolver;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaPantallaPartidas extends VBox {
    private final ControladorCambioDePantallas controladorCambioPantallas;

    public VistaPantallaPartidas(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("vista-pantalla-partidas");

        this.getChildren().add(new VistaListadoPartidas());

        Button botonReiniciar = this.crearBotonConControlador("Reiniciar", new ControladorBotonReiniciarJuego(this.controladorCambioPantallas));
        Button botonVolver = this.crearBotonConControlador("Volver", new ControladorBotonVolver(this.controladorCambioPantallas));
        this.getChildren().add(botonReiniciar);
        this.getChildren().add(botonVolver);
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }
}
