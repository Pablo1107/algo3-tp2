package edu.fiuba.algo3.modelo.mapa.obstaculos;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

public abstract class Obstaculo extends Elemento {
    public Obstaculo(Posicion posicion) {
        super(posicion);
    }

    public abstract void chocarCon(Jugador jugador);

    public abstract int aplicarPenalizacion(Moto moto);

    public abstract int aplicarPenalizacion(Auto auto);

    public abstract int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro);
}
