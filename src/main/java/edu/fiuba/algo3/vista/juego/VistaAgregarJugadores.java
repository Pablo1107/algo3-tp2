package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.controlador.ControladorAgregarJugador;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaAgregarJugadores extends VBox {
    private final ControladorAgregarJugador controladorAgregarJugador;
    private final HBox nombresJugadoresAgregados;

    public VistaAgregarJugadores() {
        this.controladorAgregarJugador = new ControladorAgregarJugador();
        this.nombresJugadoresAgregados = new HBox();
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("lista-vertical");

        this.getChildren().add(this.nombresJugadoresAgregados);

        TextField inputNombreJugador = new TextField();
        inputNombreJugador.setId("input-nombre-jugador");
        inputNombreJugador.setPromptText("nombre del jugador");
        inputNombreJugador.setMaxWidth(300);

        this.getChildren().add(inputNombreJugador);
        this.getChildren().add(this.crearBotonAgregarJugador(inputNombreJugador));
    }

    private Button crearBotonAgregarJugador(TextField inputNombreJugador) {
        Button botonAgregarJugador = new Button("Agregar Jugador");

        botonAgregarJugador.setOnAction(evento -> {
            String nombreJugador = inputNombreJugador.getText();
            if (nombreJugador.length() == 0) {
                return;
            }

            this.controladorAgregarJugador.agregarJugador(nombreJugador);
            this.nombresJugadoresAgregados.getChildren().add(new Text(nombreJugador));
        });

        return botonAgregarJugador;
    }
}
