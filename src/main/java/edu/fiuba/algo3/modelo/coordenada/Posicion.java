package edu.fiuba.algo3.modelo.coordenada;

public class Posicion implements ICoordenada {
	private int x;
	private int y;

	public Posicion(int unaX, int unaY) {
		if (unaX < 0 || unaY < 0) {
			// TODO: No se si esta bien tirar una excepcion aqui???
			throw new RuntimeException("No se puede crear una posicion con coordenadas negativas");
		}

		x = unaX;
		y = unaY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Posicion desplazar(Direccion direccion) {
		int nuevoX = x + direccion.getX();
		int nuevoY = y + direccion.getY();
		return new Posicion(nuevoX, nuevoY);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Posicion)) {
			return false;
		}

		Posicion otraCoordenada = (Posicion)o;
		return x == otraCoordenada.getX() && y == otraCoordenada.getY();
	}
}
