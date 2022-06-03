package edu.fiuba.algo3.modelo;

public class Ciudad {
    int iMax;
    int jMax;

    Obstaculo[][] obstaculos;

    public Ciudad() {
        this.iMax = 10;
        this.jMax = 10;
        this.obstaculos = new Obstaculo[this.iMax][this.jMax];
    }

    public boolean posicionEstaEnDentroDeLimites(int i, int j) {
        return i >= 0 && i < this.iMax && j >= 0 && j < this.jMax;
    }

    public void agregarObstaculo(Obstaculo obstaculo, int i, int j) {
        this.obstaculos[i][j] = obstaculo;
    }

    public Obstaculo getObstaculo(int i, int j) {
        return obstaculos[i][j];
    }
}
