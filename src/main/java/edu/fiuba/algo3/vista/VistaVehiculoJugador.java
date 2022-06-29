package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.vista.juego.VistaJuego;

public class VistaVehiculoJugador extends VistaElementoTablero {
    private static final String IMAGEN_MOTO = "src/main/resources/img/vehiculos/moto.png";
    private static final String IMAGEN_AUTO = "src/main/resources/img/vehiculos/auto.png";
    private static final String IMAGEN_CUATROXCUATRO = "src/main/resources/img/vehiculos/cuatroxcuatro.png";

    private final Jugador jugador;

    public VistaVehiculoJugador(Jugador jugador) {
        this.jugador = jugador;
        this.ajustarEscalaVista();
        this.cargarRecursoImagen(IMAGEN_MOTO);
    }

    public void actualizarVista() {
        this.sincronizarPosicionVistaConJugador();
        this.cambiarImagenVista();
    }

    protected void cambiarImagenVista() {
        Vehiculo vehiculoActualJugador = jugador.getVehiculo();
        if (vehiculoActualJugador instanceof Moto) {
            this.cargarRecursoImagen(IMAGEN_MOTO);
        } else if (vehiculoActualJugador instanceof Auto) {
            this.cargarRecursoImagen(IMAGEN_AUTO);
        } else if (vehiculoActualJugador instanceof CuatroXCuatro) {
            this.cargarRecursoImagen(IMAGEN_CUATROXCUATRO);
        }
    }

    private void sincronizarPosicionVistaConJugador() {
        Posicion posicionActualJugador = this.jugador.getPosicion();
        this.setX(posicionActualJugador.getX() * VistaJuego.FACTOR_ESCALA);
        this.setY(posicionActualJugador.getY() * VistaJuego.FACTOR_ESCALA);
    }
}
