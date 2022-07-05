package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class VistaSorpresa extends VistaElemento {
    private static final String IMAGEN_SORPRESA = "src/main/resources/img/mapa/sorpresa.png";
    private final Elemento elemento;

    public VistaSorpresa(Elemento elemento) {
        this.elemento = elemento;
        this.ajustarEscalaVista();
        this.renderizar();
        this.cambiarImagen();
    }

    @Override
    public void renderizar() {
        Posicion posicion = this.elemento.getPosicion();
        this.setX(posicion.getX() * VistaPantallaJuego.FACTOR_ESCALA_PX);
        this.setY(posicion.getY() * VistaPantallaJuego.FACTOR_ESCALA_PX);
    }

    @Override
    protected void cambiarImagen() {
        this.cargarRecursoImagen(IMAGEN_SORPRESA);
    }
}
