package edu.fiuba.algo3.vista.inicio;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.ControladorAyuda;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.controlador.ControladorCerrarJuego;
import edu.fiuba.algo3.controlador.ControladorRankings;
import edu.fiuba.algo3.controlador.ControladorRegistrarJugadores;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloPantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class VistaPantallaInicio extends VBox {
    private static final int TAMANIO_TITULO = 86;

    private final ControladorCambioDePantallas controladorCambioPantallas;

    public VistaPantallaInicio(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        ContenedorBotones contenedorBotones = new ContenedorBotones();

        contenedorBotones.agregarBoton(this.crearBotonConControlador("Iniciar Juego", new ControladorRegistrarJugadores(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Rankings", new ControladorRankings(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Ayuda", new ControladorAyuda(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Cerrar", new ControladorCerrarJuego()));

        this.getChildren().add(new VistaBarraDeMenu(this.controladorCambioPantallas));

        VBox vbox = new VBox(new TituloPantalla(App.TITULO_JUEGO, TAMANIO_TITULO), contenedorBotones);
        vbox.getStyleClass().add("vista-pantalla-centrada");
        VBox.setVgrow(vbox, Priority.ALWAYS);
        this.getChildren().add(vbox);
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }
}
