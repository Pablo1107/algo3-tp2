package edu.fiuba.algo3.modelo.mapa;

public class Posicion {
	private int x;
	private int y;

	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public Posicion desplazar(Direccion direccion) {
		int x = this.x + direccion.getX();
		int y = this.y + direccion.getY();
		return new Posicion(x, y);
	}

    public boolean estaDentroDelMapa(Mapa mapa) {
        return (0 <= this.x && this.x < mapa.getLimiteX()) && (0 <= this.y && this.y < mapa.getLimiteY());
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
