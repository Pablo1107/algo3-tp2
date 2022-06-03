package edu.fiuba.algo3.modelo;

public class Jugador {
    public int iPos;
    public int jPos;
    private Vehiculo vehiculo;
    private Ciudad ciudad;

    public Jugador(Ciudad ciudad) {
        this.iPos = 0;
        this.jPos = 0;
        this.vehiculo = new Auto();
        this.ciudad = ciudad;
    }

    private void actualizaPos(int iNueva, int jNueva) {
        if (this.ciudad.posicionEstaEnDentroDeLimites(iNueva, jNueva)) {
            this.iPos = iNueva;
            this.jPos = jNueva;
        }
    }

    public void mover(String direccion) {
        if (this.vehiculo.getPenalizaciones() > 0) {
            this.vehiculo.reducirPena();
            return;
        }
        switch (direccion) {
            case "arriba":
                actualizaPos(this.iPos, this.jPos - 1);
                break;
            case "abajo":
                actualizaPos(this.iPos, this.jPos + 1);
                break;
            case "izquierda":
                actualizaPos(this.iPos - 1, this.jPos);
                break;
            case "derecha":
                actualizaPos(this.iPos + 1, this.jPos);
                break;
            default:
                return;
        }
        Obstaculo obstaculo = ciudad.getObstaculo(this.iPos, this.jPos);
        this.vehiculo.pisar(obstaculo);
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
}
