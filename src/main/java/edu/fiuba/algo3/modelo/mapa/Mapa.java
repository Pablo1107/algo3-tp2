package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.coordenada.Posicion;

public class Mapa implements IValidadorDePosicion {
	int ancho;
	int alto;

    public Mapa(int unAncho, int unAlto) {
		ancho = unAncho;
		alto = unAlto;
    }

	public boolean validar(Posicion posicion) {
		return (posicion.getX() < ancho) && (posicion.getY() < alto);
	}
}
