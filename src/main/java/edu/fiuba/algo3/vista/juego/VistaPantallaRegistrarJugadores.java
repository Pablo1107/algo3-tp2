package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloPantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VistaPantallaRegistrarJugadores extends VBox {
    private static final int TAMANIO_TITULO = 50;
    private final ControladorCambioDePantallas controladorCambioDePantallas;
    private final ControladorAgregarJugador controladorAgregarJugador = new ControladorAgregarJugador();

    public VistaPantallaRegistrarJugadores(ControladorCambioDePantallas controladorCambioDePantallas) {
        this.controladorCambioDePantallas = controladorCambioDePantallas;
        this.inicializarlizarVista();
    }

    private void inicializarlizarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");
        this.getChildren().add(new TituloPantalla(App.TITULO_JUEGO, TAMANIO_TITULO));

        this.agregarContenedorAgregarJugador();

        ContenedorBotones contenedorBotones = new ContenedorBotones();
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Iniciar Partida", new ControladorBotonIniciarPartida(this.controladorCambioDePantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Volver", new ControladorBotonVolverAlInicio(this.controladorCambioDePantallas)));

        this.getChildren().add(contenedorBotones);
    }

    private void agregarContenedorAgregarJugador() {
        VBox contenedorAgregarJugadores = new VBox();
        contenedorAgregarJugadores.getStyleClass().add("lista-vertical");

        TextField inputNombreJugador = new TextField();
        inputNombreJugador.setId("input-nombre-jugador");
        inputNombreJugador.setPromptText("nombre del jugador");
        // TODO: Ver si puedo hacer esto con CSS.
        inputNombreJugador.setMaxWidth(300);

        contenedorAgregarJugadores.getChildren().add(inputNombreJugador);
        contenedorAgregarJugadores.getChildren().add(this.crearBotonAgregarJugador(inputNombreJugador));

        this.getChildren().add(contenedorAgregarJugadores);
    }

    // TODO: Tengo que hacer la validacion de los nombres y tambien podria agregar algun tipo de log output abajo.
    private Button crearBotonAgregarJugador(TextField inputNombreJugador) {
        Button botonAgregarJugador = new Button("Agregar Jugador");

        botonAgregarJugador.setOnAction(evento -> {
            String nombreJugador = inputNombreJugador.getText();
            if (nombreJugador.length() == 0) {
                System.out.println("Lo siento crack esta vacio");
                return;
            }

            this.controladorAgregarJugador.agregarJugador(nombreJugador);
            System.out.println("Jugador Agregado");
        });

        return botonAgregarJugador;
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }
}
