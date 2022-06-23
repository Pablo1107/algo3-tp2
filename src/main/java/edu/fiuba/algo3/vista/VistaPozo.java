package edu.fiuba.algo3.vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.fiuba.algo3.modelo.mapa.Posicion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaPozo extends ImageView {
    private static final String IMAGEN = "src/main/resources/img/mapa/pozo.png";

    public VistaPozo(Posicion posicion) {
        super();
        this.setFitWidth(VistaJuego.FACTOR_ESCALA);
        this.setFitHeight(VistaJuego.FACTOR_ESCALA);
        this.cargarImagen(IMAGEN);

        this.setX(posicion.getX() * VistaJuego.FACTOR_ESCALA);
        this.setY(posicion.getY() * VistaJuego.FACTOR_ESCALA);
    }

    // Si, definitivamente puedo hacer una abstraccion para cualquier
    // objeto que tenga una imagen y sea renderizable, como Jugador.java.
    private void cargarImagen(String archivoImagen) {
        try {
            FileInputStream stream = new FileInputStream(archivoImagen);
            this.setImage(new Image(stream));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
