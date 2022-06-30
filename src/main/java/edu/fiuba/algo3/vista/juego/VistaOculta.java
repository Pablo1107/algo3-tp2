package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class VistaOculta extends Pane {
    private Jugador jugador;
    private Mapa mapa;
    private Posicion posicionMeta;

    private final double offset = 50;
    private final double rangoVision = 200;
    private final double rangoVisionMeta = 50;

    public VistaOculta(Jugador jugador, Mapa mapa, Posicion posicionMeta) {
        super();
        this.jugador = jugador;
        this.mapa = mapa;
        this.posicionMeta = posicionMeta;

        this.actualizarVista();
    }

    public void actualizarVista() {
        Posicion posicionActualJugador = this.jugador.getPosicion();

        Shape shape = Path.subtract(new Rectangle(this.mapa.getLimiteX() * VistaPantallaJuego.FACTOR_ESCALA_PX, this.mapa.getLimiteY() * VistaPantallaJuego.FACTOR_ESCALA_PX) , new Circle(posicionMeta.getX() * VistaPantallaJuego.FACTOR_ESCALA_PX + this.offset, posicionMeta.getY() * VistaPantallaJuego.FACTOR_ESCALA_PX + this.offset, this.rangoVisionMeta));
        shape = Path.subtract(shape, new Circle(posicionActualJugador.getX() * VistaPantallaJuego.FACTOR_ESCALA_PX + this.offset, posicionActualJugador.getY() * VistaPantallaJuego.FACTOR_ESCALA_PX + this.offset, this.rangoVision));

        this.getChildren().clear();
        this.getChildren().add(shape);
    }

}
