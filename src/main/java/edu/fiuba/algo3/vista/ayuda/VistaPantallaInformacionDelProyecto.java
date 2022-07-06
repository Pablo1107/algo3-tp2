package edu.fiuba.algo3.vista.ayuda;

import edu.fiuba.algo3.controlador.ControladorVolverAPantallaAnterior;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaPantallaInformacionDelProyecto extends VBox {
    private static final String TEXTO_INFORMACION = "Este juego pertenece a un trabajo practico de la materia Algoritmos y Programacion 3 en FIUBA\n" +
            "Los alumnos integrantes son Ramiro Recchia, Carlos Castillo y Pablo Andres Dealbera\n";

    private final ControladorCambioDePantallas controladorCambioPantallas;
    private boolean estaJugando;

    public VistaPantallaInformacionDelProyecto(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.estaJugando = estaJugando;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");

        this.getChildren().add(new Text(TEXTO_INFORMACION));
        this.agregarBotonConControlador("Volver", new ControladorVolverAPantallaAnterior(this.controladorCambioPantallas, this.estaJugando));
    }

    private void agregarBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        this.getChildren().add(boton);
    }
}
