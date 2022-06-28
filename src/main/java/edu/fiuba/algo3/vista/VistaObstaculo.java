package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;

public class VistaObstaculo extends Renderizable {
    private static final String IMAGEN_POZO = "src/main/resources/img/mapa/pozo.png";
    private static final String IMAGEN_PIQUETE = "src/main/resources/img/mapa/piquete.png";
    private static final String IMAGEN_CONTROL_POLICIAL = "src/main/resources/img/mapa/policia.png";

    private final Elemento elemento;

    public VistaObstaculo(Elemento elemento) {
        super();
        this.elemento = elemento;
        this.ajustarEscala();
        this.actualizar();
        this.renderizar();
    }

    public void actualizar() {
        Posicion posicion = this.elemento.getPosicion();
        this.setX(posicion.getX() * VistaJugador.VistaJuego.FACTOR_ESCALA);
        this.setY(posicion.getY() * VistaJugador.VistaJuego.FACTOR_ESCALA);
    }

    protected void renderizar() {
        if (this.elemento instanceof Pozo) {
            this.cargarImagen(IMAGEN_POZO);
        } else if (this.elemento instanceof Piquete) {
            this.cargarImagen(IMAGEN_PIQUETE);
        } else if (this.elemento instanceof ControlPolicial) {
            this.cargarImagen(IMAGEN_CONTROL_POLICIAL);
        }
    }
}
