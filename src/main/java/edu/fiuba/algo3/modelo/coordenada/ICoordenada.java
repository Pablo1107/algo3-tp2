package edu.fiuba.algo3.modelo.coordenada;

// PREGUNTA: Aqui se me ocurrio hacer mas bien una interfaz, porque
// quiero extender el contrato de la clase `Posicion` en particular,
// si lo hago con herencia, estaria rompiendo el principio de
// sustitucion, aunque bueno, lo pongo como pregunta porque es
// discutible, la clase `Direccion` no queda con mucho, `Posicion`
// perfectamente podria heredar de ella.

public interface ICoordenada {
	public int getX();
	public int getY();
}
