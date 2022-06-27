package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class VistaMeta extends Renderizable {

    private static final String IMAGEN_META = "src/main/resources/img/mapa/meta.png";
    private final Elemento elemento;

    public VistaMeta(Elemento elemento) {
        super();
        this.elemento = elemento;
        this.ajustarEscala();
        this.actualizar();
        this.renderizar();
    }

    @Override
    public void actualizar() {
        Posicion posicion = this.elemento.getPosicion();
        this.setX(posicion.getX() * VistaJuego.FACTOR_ESCALA);
        this.setY(posicion.getY() * VistaJuego.FACTOR_ESCALA);
    }

    @Override
    protected void renderizar() {
        this.cargarImagen(IMAGEN_META);
    }
}
