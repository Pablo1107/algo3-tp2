package edu.fiuba.algo3.modelo.mapa.elemento;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public class ElementoNulo extends Elemento {
    /*public void chocarCon(Vehiculo vehiculo) {
        vehiculo.pisar(this);
    }*/

    public ElementoNulo(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public void chocarCon(Jugador jugador) {
        return;
    }

    public int aplicarPenalizacion(Moto moto) {
        return 0;
    }

    public int aplicarPenalizacion(Auto auto) {
        return 0;
    }

    public int aplicarPenalizacion(CuatroXCuatro auto) {
        return 0;
    }
}
