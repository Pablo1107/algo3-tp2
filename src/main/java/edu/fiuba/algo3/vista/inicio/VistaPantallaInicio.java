package edu.fiuba.algo3.vista.inicio;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloPantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class VistaPantallaInicio extends VBox {
    private static final int TAMANIO_TITULO = 86;

    private final ControladorCambioDePantallas controladorCambioPantallas;

    public VistaPantallaInicio(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        ContenedorBotones contenedorBotones = new ContenedorBotones();
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Iniciar Juego", new ControladorBotonIniciarJuego(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Ayuda", new ControladorBotonAyuda(this.controladorCambioPantallas, false)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Cerrar", new ControladorBotonCerrarJuego()));

        contenedorBotones.agregarBoton(this.crearBotonCircularConControlador("", new ControladorMusica()));

        this.getChildren().add(new VistaBarraDeMenu(this.controladorCambioPantallas));

        VBox vbox = new VBox(new TituloPantalla(App.TITULO_JUEGO, TAMANIO_TITULO), contenedorBotones);
        vbox.getStyleClass().add("vista-pantalla-centrada");
        VBox.setVgrow(vbox, Priority.ALWAYS);
        this.getChildren().add(vbox);
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
}
