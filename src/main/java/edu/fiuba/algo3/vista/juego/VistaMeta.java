package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class VistaMeta extends VistaElementoTablero {
    private static final String IMAGEN_META = "src/main/resources/img/mapa/meta.png";
    private final Elemento elemento;

    public VistaMeta(Elemento elemento) {
        this.elemento = elemento;
        this.ajustarEscalaVista();
        this.cambiarImagen();
        this.renderizar();
    }

    @Override
    public void renderizar() {
        Posicion posicion = this.elemento.getPosicion();
        this.setX(posicion.getX() * VistaPantallaJuego.FACTOR_ESCALA_PX);
        this.setY(posicion.getY() * VistaPantallaJuego.FACTOR_ESCALA_PX);
    }

    @Override
    protected void cambiarImagen() {
        this.cargarRecursoImagen(IMAGEN_META);
    }
}
