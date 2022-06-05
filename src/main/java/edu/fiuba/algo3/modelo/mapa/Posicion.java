package edu.fiuba.algo3.modelo.mapa;

public class Posicion {
	private int x;
	private int y;

	public Posicion(int unaX, int unaY) {
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
