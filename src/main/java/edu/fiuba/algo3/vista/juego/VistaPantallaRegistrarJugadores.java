package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.controlador.ControladorIniciarPartida;
import edu.fiuba.algo3.controlador.ControladorVolverAPantallaAnterior;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloPantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaPantallaRegistrarJugadores extends VBox {
    private static final int TAMANIO_TITULO = 50;
    private final ControladorCambioDePantallas controladorCambioDePantallas;
    private final Text mensajeAlerta;

    public VistaPantallaRegistrarJugadores(ControladorCambioDePantallas controladorCambioDePantallas) {
        this.controladorCambioDePantallas = controladorCambioDePantallas;
        this.mensajeAlerta = new Text();
        this.inicializarlizarVista();
    }

    private void inicializarlizarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");

        this.getChildren().add(new TituloPantalla(App.TITULO_JUEGO, TAMANIO_TITULO));
        this.getChildren().add(new VistaPromptAgregarJugadores());
        this.getChildren().add(this.mensajeAlerta);

        ContenedorBotones contenedorBotones = new ContenedorBotones();
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Iniciar Partida", new ControladorIniciarPartida(this.controladorCambioDePantallas, this)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Volver", new ControladorVolverAPantallaAnterior(this.controladorCambioDePantallas, true)));

        this.getChildren().add(contenedorBotones);
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }

    public void setAlerta(String contenido) {
        this.mensajeAlerta.setText(contenido);
    }

    public void borrarAlerta() {
        this.setAlerta("");
    }
}
