package edu.fiuba.algo3.vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaJugador extends ImageView {
    private static final String ARCHIVO_IMAGEN = "src/main/java/edu/fiuba/algo3/vista/recursos/jugador.png";
    private static final int FACTOR_ESCALA = 10;

    private Jugador jugador;

    private VistaJugador(Image image, Jugador jugador) {
        super(image);
        this.jugador = jugador;
    }

    public static VistaJugador crear(Jugador jugador) {
        try {
            FileInputStream archivoImage = new FileInputStream(ARCHIVO_IMAGEN);
            return new VistaJugador(new Image(archivoImage), jugador);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarPosicion() {
        Posicion posicionActualJugador = this.jugador.getPosicion();

        System.out.printf("PosicionJugador: (%s %s)\n", this.getX(), this.getY());

        this.setX(posicionActualJugador.getX() * FACTOR_ESCALA);
        this.setY(posicionActualJugador.getY() * FACTOR_ESCALA);
    }
}
