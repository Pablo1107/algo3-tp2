package edu.fiuba.algo3.modelo.mapa.sorpresas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class Desfavorable extends Sorpresa {
    private static final double FACTOR_AUMENTO_MOVIMIENTOS = 0.25;

    public Desfavorable(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void chocarCon(Jugador jugador) {
        int movimientosJugador = jugador.getMovimientos();
        double movimientosAumentados = this.calcularMovimientosAumentados(movimientosJugador);
        int movimientosActuales = (int)(movimientosJugador + movimientosAumentados);

        jugador.setMovimientos(movimientosActuales);
    }

    private double calcularMovimientosAumentados(int movimientosJugador) {
        return (int)(movimientosJugador * Desfavorable.FACTOR_AUMENTO_MOVIMIENTOS);
    }
}
