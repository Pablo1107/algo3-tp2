package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.vista.pantallas.VistaPantallaJuego;

public class VistaSorpresa extends VistaElementoTablero {
    private static final String IMAGEN_SORPRESA = "src/main/resources/img/mapa/sorpresa.png";
    private final Elemento elemento;

    public VistaSorpresa(Elemento elemento) {
        this.elemento = elemento;
        this.ajustarEscalaVista();
        this.actualizarVista();
        this.cambiarImagenVista();
    }

    @Override
    public void actualizarVista() {
        Posicion posicion = this.elemento.getPosicion();
        this.setX(posicion.getX() * VistaPantallaJuego.FACTOR_ESCALA);
        this.setY(posicion.getY() * VistaPantallaJuego.FACTOR_ESCALA);
    }

    @Override
    protected void cambiarImagenVista() {
        this.cargarRecursoImagen(IMAGEN_SORPRESA);
    }
}
