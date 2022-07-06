package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;

public class VistaObstaculo extends VistaElemento {
    private static final String IMAGEN_POZO = "src/main/resources/img/mapa/pozo.png";
    private static final String IMAGEN_PIQUETE = "src/main/resources/img/mapa/piquete.png";
    private static final String IMAGEN_CONTROL_POLICIAL = "src/main/resources/img/mapa/policia.png";

    private final Elemento elemento;

    public VistaObstaculo(Elemento elemento) {
        this.elemento = elemento;
        this.ajustarEscalaVista();
        this.renderizar();
        this.cambiarImagen();
    }

    @Override
    public void renderizar() {
        Posicion posicion = this.elemento.getPosicion();
        this.setX(posicion.getX() * VistaPantallaPartida.FACTOR_ESCALA_PX);
        this.setY(posicion.getY() * VistaPantallaPartida.FACTOR_ESCALA_PX);
    }

    @Override
    protected void cambiarImagen() {
        if (this.elemento instanceof Pozo) {
            this.cargarRecursoImagen(IMAGEN_POZO);
        } else if (this.elemento instanceof Piquete) {
            this.cargarRecursoImagen(IMAGEN_PIQUETE);
        } else if (this.elemento instanceof ControlPolicial) {
            this.cargarRecursoImagen(IMAGEN_CONTROL_POLICIAL);
        }
    }
}
