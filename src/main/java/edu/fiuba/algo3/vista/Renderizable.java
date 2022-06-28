package edu.fiuba.algo3.vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Renderizable extends ImageView {
    protected void ajustarEscala() {
        this.setFitWidth(VistaJugador.VistaJuego.FACTOR_ESCALA);
        this.setFitHeight(VistaJugador.VistaJuego.FACTOR_ESCALA);
    }

    public abstract void actualizar();

    protected abstract void renderizar();

    protected void cargarImagen(String archivoImagen) {
        try {
            FileInputStream stream = new FileInputStream(archivoImagen);
            this.setImage(new Image(stream));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
