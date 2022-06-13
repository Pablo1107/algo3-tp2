package edu.fiuba.algo3.modelo.mapa.sorpresas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;

public class Favorable extends Sorpresa {
    private static final double FACTOR_REDUCCION_MOVIMIENTOS = 0.2;

    public Favorable(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void chocarCon(Jugador jugador) {
        int movimientosJugador = jugador.getMovimientos();
        double movimientosDescontados = this.calcularMovimientosDescontados(movimientosJugador);
        int movimientosActuales = (int) (movimientosJugador - movimientosDescontados);

        jugador.setMovimientos(movimientosActuales);
    }

    private double calcularMovimientosDescontados(int movimientosJugador) {
        return movimientosJugador * Favorable.FACTOR_REDUCCION_MOVIMIENTOS;
    }
}
