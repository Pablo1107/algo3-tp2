package edu.fiuba.algo3.modelo.mapa;

public class Mapa {
	int ancho;
	int alto;
	Elemento[][] elementos;

    public Mapa(int unAncho, int unAlto) {
		if (unAncho <= 0 || unAlto <= 0) {
			throw new RuntimeException("No se puede crear un mapa con dimensiones menores o iguales a 0");
		}

		ancho = unAncho;
		alto = unAlto;
		elementos = new Elemento[ancho][alto];
    }

	public void setElementoEnPosicion(Elemento elemento, Posicion posicion) {
		if (!posicionEstaDentroDelMapa(posicion)) {
			throw new RuntimeException("No se puede posicionar un elemento fuera del mapa");
		}

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
		return (0 <= posicion.getX() && posicion.getX() < ancho) &&
			(0 <= posicion.getY() && posicion.getY() < alto);
	}
}
