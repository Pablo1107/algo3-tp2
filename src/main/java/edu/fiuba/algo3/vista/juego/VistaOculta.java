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
    private final double offset = 50;
    private final double rangoVision = 200;
    private final double rangoVisionMeta = 50;
    private Jugador jugador;
    private Mapa mapa;
    private Posicion posicionMeta;

    public VistaOculta(Partida partidaActual) {
        this.jugador = partidaActual.getJugadorEnTurno();
        this.mapa = partidaActual.getMapa();
        this.posicionMeta = partidaActual.getMeta().getPosicion();
        this.renderizar();
    }

    public void renderizar() {
        Posicion posicionActualJugador = this.jugador.getPosicion();

        Shape shape = Path.subtract(new Rectangle(this.mapa.getLimiteX() * VistaPantallaPartida.FACTOR_ESCALA_PX, this.mapa.getLimiteY() * VistaPantallaPartida.FACTOR_ESCALA_PX), new Circle(posicionMeta.getX() * VistaPantallaPartida.FACTOR_ESCALA_PX + this.offset, posicionMeta.getY() * VistaPantallaPartida.FACTOR_ESCALA_PX + this.offset, this.rangoVisionMeta));
        shape = Path.subtract(shape, new Circle(posicionActualJugador.getX() * VistaPantallaPartida.FACTOR_ESCALA_PX + this.offset, posicionActualJugador.getY() * VistaPantallaPartida.FACTOR_ESCALA_PX + this.offset, this.rangoVision));

        this.getChildren().clear();
        this.getChildren().add(shape);
    }

}
