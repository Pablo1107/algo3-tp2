package edu.fiuba.algo3.modelo.mapa.obstaculos;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

import java.util.Random;

public class ControlPolicial extends Obstaculo {
    private static final double PROBABILIDAD_MOTO = 0.8;
    private static final double PROBABILIDAD_AUTO = 0.5;
    private static final double PROBABILIDAD_CUATROxCUATRO = 0.3;
    private static final int PENALIZACION = 3;

    public ControlPolicial(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void chocarCon(Jugador jugador) {
        jugador.getVehiculo().pisar(this);
    }

    public int aplicarPenalizacion(Moto moto) {
        return this.calcularPenalizacion(ControlPolicial.PROBABILIDAD_MOTO);
    }

    public int aplicarPenalizacion(Auto auto) {
        return this.calcularPenalizacion(ControlPolicial.PROBABILIDAD_AUTO);
    }

    public int aplicarPenalizacion(CuatroXCuatro cuatroXCuatro) {
        return this.calcularPenalizacion(ControlPolicial.PROBABILIDAD_CUATROxCUATRO);
    }

    private int calcularPenalizacion(double probabilidad) {
        return this.esPenalizado(probabilidad) ? ControlPolicial.PENALIZACION : 0;
    }

    private boolean esPenalizado(double probabilidad) {
        Random random = new Random();
        return random.nextDouble() < probabilidad;
    }
}
