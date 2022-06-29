package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import edu.fiuba.algo3.vista.pantallas.juego.VistaPantallaJuego;

public class VistaObstaculo extends VistaElementoTablero {
    private static final String IMAGEN_POZO = "src/main/resources/img/mapa/pozo.png";
    private static final String IMAGEN_PIQUETE = "src/main/resources/img/mapa/piquete.png";
    private static final String IMAGEN_CONTROL_POLICIAL = "src/main/resources/img/mapa/policia.png";

    private final Elemento elemento;

    public VistaObstaculo(Elemento elemento) {
        this.elemento = elemento;
        this.ajustarEscalaVista();
        this.actualizarVista();
        this.cambiarImagenVista();
    }

    public void actualizarVista() {
        Posicion posicion = this.elemento.getPosicion();
        this.setX(posicion.getX() * VistaPantallaJuego.FACTOR_ESCALA);
        this.setY(posicion.getY() * VistaPantallaJuego.FACTOR_ESCALA);
    }

    protected void cambiarImagenVista() {
        if (this.elemento instanceof Pozo) {
            this.cargarRecursoImagen(IMAGEN_POZO);
        } else if (this.elemento instanceof Piquete) {
            this.cargarRecursoImagen(IMAGEN_PIQUETE);
        } else if (this.elemento instanceof ControlPolicial) {
            this.cargarRecursoImagen(IMAGEN_CONTROL_POLICIAL);
        }
    }
}
