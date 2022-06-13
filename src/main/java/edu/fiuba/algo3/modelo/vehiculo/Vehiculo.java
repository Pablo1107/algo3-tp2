package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.ElementoNulo;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;

public abstract class Vehiculo {
    protected int penalizaciones;

    public Vehiculo() {
        this.penalizaciones = 0;
    }

    public void pisar(ElementoNulo elementoNulo) {
        return;
    }

    public abstract void pisar(Pozo pozo);

    public abstract void pisar(Piquete piquete);

    public abstract void pisar(ControlPolicial controlPolicial);

    public void reducirPenalizaciones() {
        this.penalizaciones--;
    }

    public boolean tienePenalizaciones() {
        return this.penalizaciones > 0;
    }

    public int getPenalizaciones() {
        return this.penalizaciones;
    }

    public abstract void retroceder(Jugador jugador);
}
