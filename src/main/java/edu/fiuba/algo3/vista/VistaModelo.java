package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.mapa.Mapa;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VistaModelo {
    private VistaJugador vistaJugador;
    private Mapa mapa;

    private Scene scene;

    public VistaModelo(Mapa mapa, Stage stage) {
        this.vistaJugador = VistaJugador.crear();
        this.mapa = mapa;

        // Aqui probablemente no queremos que la root sea el jugador,
        // pero por el momento solo quiero que funcione.
        Parent root = new Group(this.vistaJugador);
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
