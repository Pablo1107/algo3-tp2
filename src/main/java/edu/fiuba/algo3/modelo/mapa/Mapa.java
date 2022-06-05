package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.mapa.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.mapa.obstaculo.ObstaculoNulo;

public class Mapa {
	int ancho;
	int alto;
	Obstaculo[][] elementos;

    public Mapa(int unAncho, int unAlto) {
		if (unAncho <= 0 || unAlto <= 0) {
			throw new RuntimeException("No se puede crear un mapa con dimensiones menores o iguales a 0");
		}

		ancho = unAncho;
		alto = unAlto;
		elementos = new Obstaculo[ancho][alto];

		for (int x = 0; x < unAncho; x++) {
			for (int y = 0; y < unAlto; y++) {
				elementos[x][y] = new ObstaculoNulo();
			}
		}
    }

	public void setElementoEnPosicion(Obstaculo elemento, Posicion posicion) {
		if (!posicionEstaDentroDelMapa(posicion)) {
			throw new RuntimeException("No se puede posicionar un elemento fuera del mapa");
		}

		if (hayElementoEnPosicion(posicion)) {
			return;
		}

		elementos[posicion.getX()][posicion.getY()] = elemento;
	}

	private boolean hayElementoEnPosicion(Posicion posicion) {
		return elementos[posicion.getX()][posicion.getY()].getClass() != ObstaculoNulo.class;
	}

	public Obstaculo getElementoEnPosicion(Posicion posicion) {
		if (!posicionEstaDentroDelMapa(posicion)) {
			return new ObstaculoNulo();
		}

		return elementos[posicion.getX()][posicion.getY()];
	}

	public boolean posicionEstaDentroDelMapa(Posicion posicion) {
		return (0 <= posicion.getX() && posicion.getX() < ancho) &&
			(0 <= posicion.getY() && posicion.getY() < alto);
	}
}
