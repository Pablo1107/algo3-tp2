package edu.fiuba.algo3.modelo.coordenada;

public class Coordenada {
	private int x;
	private int y;

	public Coordenada(int unaX, int unaY) {
		x = unaX;
		y = unaY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Coordenada desplazar(Coordenada direccion) {
		int nuevoX = x + direccion.getX();
		int nuevoY = y + direccion.getY();
		return new Coordenada(nuevoX, nuevoY);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Coordenada)) {
			return false;
		}

		Coordenada otraCoordenada = (Coordenada)o;
		return x == otraCoordenada.getX() && y == otraCoordenada.getY();
	}
}
