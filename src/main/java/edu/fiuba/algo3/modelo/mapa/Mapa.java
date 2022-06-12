package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.mapa.elemento.ElementoNulo;
import edu.fiuba.algo3.modelo.mapa.elemento.IChocable;

public class Mapa {
	int ancho;
	int alto;
	IChocable[][] elementos;

    public Mapa(int unAncho, int unAlto) {
		if (unAncho <= 0 || unAlto <= 0) {
			throw new RuntimeException("No se puede crear un mapa con dimensiones menores o iguales a 0");
		}

		this.ancho = unAncho;
		this.alto = unAlto;
		this.elementos = new IChocable[ancho][alto];

		for (int x = 0; x < unAncho; x++) {
			for (int y = 0; y < unAlto; y++) {
				this.elementos[x][y] = new ElementoNulo();
			}
		}
    }

	public void setElementoEnPosicion(IChocable elemento, Posicion posicion) {
		if (!posicionEstaDentroDelMapa(posicion)) {
			throw new RuntimeException("No se puede posicionar un elemento fuera del mapa");
		}

		if (hayElementoEnPosicion(posicion)) {
			return;
		}

		this.elementos[posicion.getX()][posicion.getY()] = elemento;
	}

	private boolean hayElementoEnPosicion(Posicion posicion) {
		return this.elementos[posicion.getX()][posicion.getY()].getClass() != ElementoNulo.class;
	}

	public IChocable getElementoEnPosicion(Posicion posicion) {
		if (!posicionEstaDentroDelMapa(posicion)) {
			return new ElementoNulo();
		}

		return this.elementos[posicion.getX()][posicion.getY()];
	}

	public boolean posicionEstaDentroDelMapa(Posicion posicion) {
		return (0 <= posicion.getX() && posicion.getX() < this.ancho) &&
			(0 <= posicion.getY() && posicion.getY() < this.alto);
	}
}
