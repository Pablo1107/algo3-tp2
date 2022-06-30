package edu.fiuba.algo3.vista.juego;

import java.util.List;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Meta;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Sorpresa;
import javafx.scene.layout.Pane;

public class VistaMapa extends Pane {
    private Mapa mapa;

    public VistaMapa(Mapa mapa) {
        this.mapa = mapa;
        this.inicializarVista();
    }

    private void inicializarVista() {
        List<Elemento> elementos = this.mapa.getElementos();
        for (Elemento e : elementos) {
            if(e instanceof Obstaculo) {
                this.getChildren().add(new VistaObstaculo(e));
            } else if (e instanceof Sorpresa) {
              this.getChildren().add(new VistaSorpresa(e));
            } else if(e instanceof Meta) {
                this.getChildren().add(new VistaMeta(e));
            } else {
                this.getChildren().add(new VistaElementoNulo(e));
            }
        }
    }
}
