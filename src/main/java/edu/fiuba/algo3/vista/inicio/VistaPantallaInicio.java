package edu.fiuba.algo3.vista.inicio;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.ControladorBotonAyuda;
import edu.fiuba.algo3.controlador.ControladorBotonCerrarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VistaPantallaInicio extends VBox {
    private final ControladorCambioDePantallas controladorCambioPantallas;
    private final String FUENTE_TITULO = "titulo.ttf";
    private final int TAMANIO_TITULO = 86;

    public VistaPantallaInicio(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("vista-pantalla-inicio");

        Text titulo = new Text(App.TITULO);
        Font fuenteTitulo = Font.loadFont(App.class.getResource(FUENTE_TITULO).toExternalForm(), TAMANIO_TITULO);
        titulo.setFont(fuenteTitulo);

        this.getChildren().add(titulo);
        this.getChildren().add(this.contenedorBotones());
    }

    private VBox contenedorBotones() {
        VBox contenedor = new VBox(); 
        contenedor.setId("contenedor-botones-inicio");

        contenedor.getChildren().add(this.crearBotonConControlador("Iniciar Juego", new ControladorBotonIniciarJuego(this.controladorCambioPantallas)));
        contenedor.getChildren().add(this.crearBotonConControlador("Ayuda", new ControladorBotonAyuda(this.controladorCambioPantallas)));
        contenedor.getChildren().add(this.crearBotonConControlador("Cerrar", new ControladorBotonCerrarJuego()));

        return contenedor;
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }
}
