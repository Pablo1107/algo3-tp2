package edu.fiuba.algo3.vista.partidas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.fiuba.algo3.controlador.ControladorBotonReiniciarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonVolver;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloPantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class VistaPantallaResultados extends VBox {
    private static final int TAMANIO_TITULO = 36;
    private static final String IMAGEN_GANADOR = "src/main/resources/img/ganador.png";

    private final ControladorCambioDePantallas controladorCambioPantallas;

    public VistaPantallaResultados(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");

        this.getChildren().add(new TituloPantalla("Fin del Juego", TAMANIO_TITULO));
        this.getChildren().add(this.crearImagenFinalPartida());
        this.getChildren().add(new VistaListadoResultados());

        ContenedorBotones contenedorBotones = new ContenedorBotones();
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Reiniciar", new ControladorBotonReiniciarJuego(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Volver", new ControladorBotonVolver(this.controladorCambioPantallas, false)));

        this.getChildren().add(contenedorBotones);
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }

    private ImageView crearImagenFinalPartida() {
        ImageView imageView = new ImageView(this.getRecursoImagen(IMAGEN_GANADOR));
        return imageView;
    }

    private Image getRecursoImagen(String archivoImagen) {
        try {
            FileInputStream stream = new FileInputStream(archivoImagen);
            return new Image(stream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
