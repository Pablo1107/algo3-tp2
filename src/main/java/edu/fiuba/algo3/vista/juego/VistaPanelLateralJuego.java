package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloPantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class VistaPanelLateralJuego extends VBox {
    private static final int TAMANIO_TITULO = 36;

    private final ControladorCambioDePantallas controladorCambioPantallas;
    private final Text contadorPuntajeActual;

    public VistaPanelLateralJuego(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.contadorPuntajeActual = this.crearContadorPuntajeActual();
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("panel-lateral-juego");
        this.getStyleClass().add("lista-vertical");

        this.contadorPuntajeActual.setId("contador-puntaje-actual");

        ContenedorBotones contenedorBotones = new ContenedorBotones();
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Reiniciar", new ControladorBotonReiniciarJuego(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Volver", new ControladorBotonVolver(this.controladorCambioPantallas, false)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Ayuda", new ControladorBotonAyuda(this.controladorCambioPantallas, true)));

        contenedorBotones.agregarBoton(this.crearBotonCircularConControlador("", new ControladorMusica()));

        this.getChildren().add(new TituloPantalla(App.TITULO_JUEGO, TAMANIO_TITULO));
        this.getChildren().add(this.contadorPuntajeActual);
        this.getChildren().add(contenedorBotones);
    }

    private Button crearBotonCircularConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        double r = 20;
        Button boton = new Button(contenido);
        boton.setShape(new Circle(r));
        boton.setMinSize(2*r, 2*r);
        boton.setMaxSize(2*r, 2*r);

        ImageView iconoMusica = new ImageView(new Image(App.class.getResourceAsStream("corchea.png")));

        iconoMusica.setFitHeight(1.5*r);
        iconoMusica.setFitWidth(1.5*r);

        boton.setGraphic(iconoMusica);

        boton.setOnAction(controlador);
        return boton;
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }

    private Text crearContadorPuntajeActual() {
        int movimientosActualesJugador = this.getMovimientosActualesJugador();
        String formato = String.format("Movimientos Actuales: %s", movimientosActualesJugador);
        return new Text(formato);
    }

    public void actualizarContadorPuntajeActual() {
        this.contadorPuntajeActual.setText(String.valueOf(this.getMovimientosActualesJugador()));
    }

    private int getMovimientosActualesJugador() {
        return Juego.getInstancia().getPartidaActual().getJugadorEnTurno().getMovimientos();
    }
}
