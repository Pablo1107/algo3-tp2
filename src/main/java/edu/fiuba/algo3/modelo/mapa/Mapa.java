package edu.fiuba.algo3.modelo.mapa;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.elemento.ElementoNulo;

public class Mapa {
	int limiteX;
	int limiteY;
	List<Elemento> elementos;

    public Mapa(int limiteX, int limiteY) {
		if (limiteX <= 0 || limiteY <= 0) {
			throw new RuntimeException("No se puede crear un mapa con dimensiones menores o iguales a 0");
		}

		this.limiteX = limiteX;
		this.limiteY = limiteY;
		this.elementos = new ArrayList<>();
    }

    public void agregarElemento(Elemento elemento) {
        // Okay aqui puedo hacer dos cosas, o hago que directamente no
        // se puedan crear elementos fuera del mapa (para lo cual
        // necesitaria conocer el mapa al crear cada elemento), o
        // hago que no se puedan agregar elementos que fueron creados
        // fuera del mapa. Voy por la segunda ahora.

        if (!elemento.estaDentroDelMapa(this)) {
        }

        this.elementos.add(elemento);
    }

	public void setElementoEnPosicion(Elemento elemento, Posicion posicion) {
		if (!posicionEstaDentroDelMapa(posicion)) {
			throw new RuntimeException("No se puede posicionar un elemento fuera del mapa");
		}

		if (hayElementoEnPosicion(posicion)) {
			return;
		}
	}

	private boolean hayElementoEnPosicion(Posicion posicion) {
        return true;
	}

	public Elemento getElementoEnPosicion(Posicion posicion) {
        return new ElementoNulo(posicion);
	}

	public boolean posicionEstaDentroDelMapa(Posicion posicion) {
		return (0 <= posicion.getX() && posicion.getX() < limiteX) &&
			(0 <= posicion.getY() && posicion.getY() < limiteY);
	}

    public int getLimiteX() {
        return this.limiteX;
    }

    public int getLimiteY() {
        return this.limiteY;
    }
}
