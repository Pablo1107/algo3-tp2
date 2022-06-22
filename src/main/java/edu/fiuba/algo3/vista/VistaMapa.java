package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.mapa.Mapa;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaMapa extends Rectangle {
    private static final int FACTOR_ESCALA_COORDENADAS = 10;

    public VistaMapa(Mapa mapa) {
        super();
        this.setWidth(mapa.getLimiteX() * VistaMapa.FACTOR_ESCALA_COORDENADAS + 100);
        this.setHeight(mapa.getLimiteY() * VistaMapa.FACTOR_ESCALA_COORDENADAS + 137);
        this.setFill(Color.LIGHTBLUE);
    }
}
