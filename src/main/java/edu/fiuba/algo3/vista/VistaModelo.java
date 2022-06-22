package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.mapa.Mapa;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VistaModelo {
    private VistaJugador vistaJugador;

    private Scene scene;

    public VistaModelo(Mapa mapa, Stage stage) {
        this.vistaJugador = VistaJugador.crear();

        // Aqui probablemente no queremos que la root sea el jugador,
        // pero por el momento solo quiero que funcione.
        Group root = new Group(this.vistaMapa);
        root.getChildren().add(this.vistaJugador);
        this.scene = new Scene(root);

        this.inicializarMovimiento();

        stage.setScene(this.scene);
    }

    public void inicializarMovimiento() {
        this.scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
            case RIGHT:
                vistaJugador.moverDerecha(this.mapa);
                break;
            case LEFT:
                vistaJugador.moverIzquierda(this.mapa);
                break;
            case UP:
                vistaJugador.moverArriba(this.mapa);
                break;
            case DOWN:
                vistaJugador.moverAbajo(this.mapa);
                break;
            default:
                break;
            }
        });
    }
}
