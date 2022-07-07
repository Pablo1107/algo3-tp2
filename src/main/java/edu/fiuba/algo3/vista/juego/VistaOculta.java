package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.modelo.juego.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class VistaOculta extends Pane {
    private static final double OFFSET = 50;
    private static final double RANGO_VISION = 200;
    private static final double RANGO_VISION_META = 50;
    private final Jugador jugador;
    private final Mapa mapa;
    private final Posicion posicionMeta;

    public VistaOculta(Partida partidaActual) {
        this.jugador = partidaActual.getJugadorEnTurno();
        this.mapa = partidaActual.getMapa();
        this.posicionMeta = partidaActual.getMeta().getPosicion();
        this.renderizar();
    }

    public void renderizar() {
        Posicion posicionActualJugador = this.jugador.getPosicion();

        Shape shape = Path.subtract(new Rectangle(this.mapa.getLimiteX() * VistaPantallaPartida.FACTOR_ESCALA_PX, this.mapa.getLimiteY() * VistaPantallaPartida.FACTOR_ESCALA_PX), new Circle(posicionMeta.getX() * VistaPantallaPartida.FACTOR_ESCALA_PX + OFFSET, posicionMeta.getY() * VistaPantallaPartida.FACTOR_ESCALA_PX + OFFSET, RANGO_VISION_META));
        shape = Path.subtract(shape, new Circle(posicionActualJugador.getX() * VistaPantallaPartida.FACTOR_ESCALA_PX + OFFSET, posicionActualJugador.getY() * VistaPantallaPartida.FACTOR_ESCALA_PX + OFFSET, RANGO_VISION));

        this.getChildren().clear();
        this.getChildren().add(shape);
    }
}