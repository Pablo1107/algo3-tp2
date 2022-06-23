package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class VistaJugador extends Renderizable {
    private static final String IMAGEN_MOTO = "src/main/resources/img/vehiculos/moto.png";
    private static final String IMAGEN_AUTO = "src/main/resources/img/vehiculos/auto.png";
    private static final String IMAGEN_CUATROXCUATRO = "src/main/resources/img/vehiculos/cuatroxcuatro.png";

    private Jugador jugador;

    public VistaJugador(Jugador jugador) {
        super();
        this.jugador = jugador;
        this.ajustarEscala();
        this.cargarImagen(IMAGEN_MOTO);
    }

    public void actualizar() {
        Posicion posicionJugador = this.jugador.getPosicion();
        this.setX(posicionJugador.getX() * VistaJuego.FACTOR_ESCALA);
        this.setY(posicionJugador.getY() * VistaJuego.FACTOR_ESCALA);
        this.renderizar();
    }

    protected void renderizar() {
        Vehiculo vehiculoActual = jugador.getVehiculo();
        if (vehiculoActual instanceof Moto) {
            this.cargarImagen(IMAGEN_MOTO);
        } else if (vehiculoActual instanceof Auto) {
            this.cargarImagen(IMAGEN_AUTO);
        } else if (vehiculoActual instanceof CuatroXCuatro) {
            this.cargarImagen(IMAGEN_CUATROXCUATRO);
        }
    }
}
