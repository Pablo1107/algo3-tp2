package edu.fiuba.algo3.modelo.mapa.sorpresas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class CambioDeVehiculo extends Sorpresa {
    private static final List<Class<? extends Vehiculo>> SECUENCIA = List.of(
        Moto.class,
        Auto.class,
        CuatroXCuatro.class
    );

    public CambioDeVehiculo(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void chocarCon(Jugador jugador) {
        Vehiculo vehiculoActual = jugador.getVehiculo();
        int i = (SECUENCIA.indexOf(vehiculoActual.getClass()) + 1) % SECUENCIA.size();
        try {
            Vehiculo vehiculoNuevo = SECUENCIA.get(i).getDeclaredConstructor().newInstance();
            jugador.setVehiculo(vehiculoNuevo);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
