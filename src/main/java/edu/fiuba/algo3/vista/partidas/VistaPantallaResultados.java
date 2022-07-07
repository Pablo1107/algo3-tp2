package edu.fiuba.algo3.vista.partidas;

import edu.fiuba.algo3.controlador.ControladorReiniciarPartida;
import edu.fiuba.algo3.controlador.ControladorVolverAPantallaDeInicio;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloPantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaPantallaResultados extends VBox {
    private static final int TAMANIO_TITULO = 36;

    private final ControladorCambioDePantallas controladorCambioPantallas;

    public VistaPantallaResultados(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");

        this.getChildren().add(new TituloPantalla("Fin del Juego", TAMANIO_TITULO));

        this.getChildren().add(new VistaListadoResultadosPartida());

        ContenedorBotones contenedorBotones = new ContenedorBotones();
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Reiniciar", new ControladorReiniciarPartida(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Volver", new ControladorVolverAPantallaDeInicio(this.controladorCambioPantallas)));

        this.getChildren().add(contenedorBotones);
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }

}
