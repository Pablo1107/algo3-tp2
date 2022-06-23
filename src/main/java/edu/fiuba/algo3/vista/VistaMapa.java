package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import javafx.scene.Group;

public class VistaMapa extends Group {
    private Mapa mapa;

    public VistaMapa(Mapa mapa) {
        super();
        this.mapa = mapa;
        this.inicializarVista();
    }

    private void inicializarVista() {
        List<Elemento> elementos = this.mapa.getElementos();
        for (Elemento e : elementos) {
            Posicion posicion = e.getPosicion();
            VistaPozo vistaPozo = new VistaPozo(posicion);
            this.getChildren().add(vistaPozo);
        }
    }
}
