package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.mapa.Mapa;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaMapa extends Rectangle {
    private VistaMapa(Mapa mapa) {
        super();

        this.setWidth(mapa.getLimiteX() * VistaJuego.FACTOR_ESCALA);
        this.setHeight(mapa.getLimiteY() * VistaJuego.FACTOR_ESCALA);
        this.setFill(Color.LIGHTBLUE);
    }

    public static VistaMapa crear(Mapa mapa) {
        return new VistaMapa(mapa);
    }
}
