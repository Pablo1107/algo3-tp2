package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.coordenada.Coordenada;

public class Mapa {
	int ancho;
	int alto;

    public Mapa(int unAncho, int unAlto) {
		ancho = unAncho;
		alto = unAlto;
    }

	public boolean posicionEstaDentroDeLosLimites(Coordenada posicion) {
		boolean xEstaDentroDeLimites = 0 <= posicion.getX() && posicion.getX() < ancho;
		boolean yEstaDentroDeLimites = 0 <= posicion.getY() && posicion.getY() < alto;
		return xEstaDentroDeLimites && yEstaDentroDeLimites;
	}
}
