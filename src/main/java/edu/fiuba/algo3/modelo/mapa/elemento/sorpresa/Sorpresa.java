package edu.fiuba.algo3.modelo.mapa.elemento.sorpresa;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.elemento.IChocable;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public abstract class Sorpresa implements IChocable {
    //public abstract void chocarCon(Vehiculo vehiculo);

    public abstract void chocarCon(Jugador jugador);
    public abstract int aplicarPenalizacion(Moto moto);

    public abstract int aplicarPenalizacion(Auto auto);

    public abstract int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro);
}
