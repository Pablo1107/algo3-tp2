package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.coordenada.Posicion;

public class Mapa {
	int ancho;
	int alto;
	Elemento[][] elementos;

    public Mapa(int unAncho, int unAlto) {
		ancho = unAncho;
		alto = unAlto;
		elementos = new Elemento[ancho][alto];
    }

	public void setElementoEnPosicion(Elemento elemento, Posicion posicion) {
		if (hayElementoEnPosicion(posicion)) {
			return;
		}

		elementos[posicion.getX()][posicion.getY()] = elemento;
	}

	private boolean hayElementoEnPosicion(Posicion posicion) {
		return elementos[posicion.getX()][posicion.getY()] != null;
	}

	public Elemento getElementoEnPosicion(Posicion posicion) {
		if (!posicionEstaDentroDelMapa(posicion)) {
			return null;
		}

		return elementos[posicion.getX()][posicion.getY()];
	}

	public boolean posicionEstaDentroDelMapa(Posicion posicion) {
		return (posicion.getX() < ancho) && (posicion.getY() < alto);
	}
}
