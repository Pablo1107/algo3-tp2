package edu.fiuba.algo3.vista.pantallas.inicio;

import edu.fiuba.algo3.controlador.ControladorBotonAyuda;
import edu.fiuba.algo3.controlador.ControladorBotonCerrarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaPantallaInicio extends VBox {
    private final ControladorCambioDePantallas controladorCambioPantallas;

    public VistaPantallaInicio(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
       this.setId("vista-pantalla-inicio");
        this.agregarBotonConControlador("Iniciar Juego", new ControladorBotonIniciarJuego(this.controladorCambioPantallas));
        this.agregarBotonConControlador("Ayuda", new ControladorBotonAyuda(this.controladorCambioPantallas));
        this.agregarBotonConControlador("Cerrar", new ControladorBotonCerrarJuego());
    }

    private void agregarBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        this.getChildren().add(boton);
    }
}
