package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloPantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaPantallaRegistrarJugadores extends VBox {
    private static final int TAMANIO_TITULO = 50;
    private final ControladorCambioDePantallas controladorCambioDePantallas;

    public VistaPantallaRegistrarJugadores(ControladorCambioDePantallas controladorCambioDePantallas) {
        this.controladorCambioDePantallas = controladorCambioDePantallas;
        this.inicializarlizarVista();
    }

    private void inicializarlizarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");

        this.getChildren().add(new TituloPantalla(App.TITULO_JUEGO, TAMANIO_TITULO));
        this.getChildren().add(new VistaAgregarJugadores());

        ContenedorBotones contenedorBotones = new ContenedorBotones();
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Iniciar Partida", new ControladorBotonIniciarPartida(this.controladorCambioDePantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Volver", new ControladorBotonVolver(this.controladorCambioDePantallas, true)));

        this.getChildren().add(contenedorBotones);
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }
}
