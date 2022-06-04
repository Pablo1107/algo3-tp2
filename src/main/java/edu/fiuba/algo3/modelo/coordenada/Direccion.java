package edu.fiuba.algo3.modelo.coordenada;

public class Direccion implements ICoordenada {
	private int x;
	private int y;

	public Direccion(int unaX, int unaY) {
		x = unaX;
		y = unaY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
