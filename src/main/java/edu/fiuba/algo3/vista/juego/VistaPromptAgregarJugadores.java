package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.controlador.ControladorAgregarJugador;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaPromptAgregarJugadores extends VBox {
    private final ControladorAgregarJugador controladorAgregarJugador;
    private final HBox nombresJugadoresAgregados;

    public VistaPromptAgregarJugadores() {
        this.controladorAgregarJugador = new ControladorAgregarJugador();
        this.nombresJugadoresAgregados = new HBox();
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("lista-vertical");
        this.nombresJugadoresAgregados.getStyleClass().add("lista-horizontal");

        this.getChildren().add(this.nombresJugadoresAgregados);

        HBox contendorPromptNombreJugador = new HBox();
        contendorPromptNombreJugador.getStyleClass().add("lista-horizontal");

        // TODO: Realmente no me gusta como estoy manejando los layouts aqui.
        TextField inputNombreJugador = new TextField();
        inputNombreJugador.setId("input-nombre-jugador");
        inputNombreJugador.setPromptText("nombre del jugador");
        inputNombreJugador.setMinHeight(65);
        inputNombreJugador.setMinWidth(300);

        contendorPromptNombreJugador.getChildren().add(inputNombreJugador);
        contendorPromptNombreJugador.getChildren().add(this.crearBotonAgregarJugador(inputNombreJugador));

        this.getChildren().add(contendorPromptNombreJugador);
    }

    private Button crearBotonAgregarJugador(TextField inputNombreJugador) {
        Button botonAgregarJugador = new Button("Agregar");
        botonAgregarJugador.setMaxWidth(150);

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
