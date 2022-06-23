package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import javafx.scene.Group;

public class VistaMapa extends Group {
    private Mapa mapa;

    public VistaMapa(Mapa mapa) {
        super();
        this.mapa = mapa;
        this.inicializar();
    }

    private void inicializar() {
        List<Elemento> elementos = this.mapa.getElementos();
        for (Elemento e : elementos) {
            this.getChildren().add(new VistaObstaculo(e));
        }
    }
}
