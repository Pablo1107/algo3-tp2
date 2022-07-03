package edu.fiuba.algo3.vista.inicio;

import edu.fiuba.algo3.controlador.ControladorBotonAyuda;
import edu.fiuba.algo3.controlador.ControladorBotonCerrarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaPantallaInicio extends VBox {
    private static final int TAMANIO_TITULO = 86;

    private final ControladorCambioDePantallas controladorCambioPantallas;

    public VistaPantallaInicio(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");

        ContenedorBotones contenedorBotones = new ContenedorBotones();
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Iniciar Juego", new ControladorBotonIniciarJuego(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Ayuda", new ControladorBotonAyuda(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Cerrar", new ControladorBotonCerrarJuego()));

        this.getChildren().add(new TituloJuego(TAMANIO_TITULO));
        this.getChildren().add(contenedorBotones);
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }
}
