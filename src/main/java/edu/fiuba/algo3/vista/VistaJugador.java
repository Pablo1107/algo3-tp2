package edu.fiuba.algo3.vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaJugador extends ImageView {
    private static final String IMAGEN_MOTO = "src/main/resources/img/vehiculos/moto.png";
    private static final String IMAGEN_AUTO = "src/main/resources/img/vehiculos/auto.png";
    private static final String IMAGEN_CUATROXCUATRO = "src/main/resources/img/vehiculos/cuatroxcuatro.png";

    private Jugador jugador;

    public VistaJugador(Jugador jugador) {
        super();
        this.setFitWidth(VistaJuego.FACTOR_ESCALA);
        this.setFitHeight(VistaJuego.FACTOR_ESCALA);
        this.jugador = jugador;
        this.cargarImagen(IMAGEN_MOTO);
    }

    public void actualizarPosicion() {
        Posicion posicionJugador = this.jugador.getPosicion();
        this.setX(posicionJugador.getX() * VistaJuego.FACTOR_ESCALA);
        this.setY(posicionJugador.getY() * VistaJuego.FACTOR_ESCALA);
        this.actualizarImagenVehiculo();
    }

    private void actualizarImagenVehiculo() {
        Vehiculo vehiculoActual = jugador.getVehiculo();
        if (vehiculoActual instanceof Moto) {
            this.cargarImagen(IMAGEN_MOTO);
        } else if (vehiculoActual instanceof Auto) {
            this.cargarImagen(IMAGEN_AUTO);
        } else if (vehiculoActual instanceof CuatroXCuatro) {
            this.cargarImagen(IMAGEN_CUATROXCUATRO);
        }
    }

    private void cargarImagen(String archivoImagen) {
        try {
            FileInputStream stream = new FileInputStream(archivoImagen);
            this.setImage(new Image(stream));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
