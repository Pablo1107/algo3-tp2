package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import javafx.scene.layout.Pane;

public class VistaMapa extends Pane {
    private Mapa mapa;

    public VistaMapa(Mapa mapa) {
        this.mapa = mapa;
        this.inicializarVista();
        this.setStyle("-fx-border-color: red;");
        this.setStyle("-fx-border-width: 1px;");
    }

    private void inicializarVista() {
        List<Elemento> elementos = this.mapa.getElementos();
        for (Elemento e : elementos) {
            this.getChildren().add(new VistaObstaculo(e));
        }
    }
}
