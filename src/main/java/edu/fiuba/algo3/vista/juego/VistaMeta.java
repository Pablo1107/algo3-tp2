package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class VistaMeta extends VistaElementoTablero {

    private static final String IMAGEN_META = "src/main/resources/img/mapa/meta.png";
    private final Elemento elemento;

    public VistaMeta(Elemento elemento) {
        super();
        this.elemento = elemento;
        this.ajustarEscalaVista();
        this.actualizarVista();
        this.cambiarImagenVista();
    }

    @Override
    public void actualizarVista() {
        Posicion posicion = this.elemento.getPosicion();
        this.setX(posicion.getX() * VistaPantallaJuego.FACTOR_ESCALA_PX);
        this.setY(posicion.getY() * VistaPantallaJuego.FACTOR_ESCALA_PX);
    }

    @Override
    protected void cambiarImagenVista() {
        this.cargarRecursoImagen(IMAGEN_META);
    }
}