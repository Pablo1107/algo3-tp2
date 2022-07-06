package edu.fiuba.algo3.vista.juego;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class VistaElemento extends ImageView {
    protected void ajustarEscalaVista() {
        this.setFitWidth(VistaPantallaPartida.FACTOR_ESCALA_PX);
        this.setFitHeight(VistaPantallaPartida.FACTOR_ESCALA_PX);
    }

    public abstract void renderizar();

    protected abstract void cambiarImagen();

    protected void cargarRecursoImagen(String archivoImagen) {
        try {
            FileInputStream stream = new FileInputStream(archivoImagen);
            this.setImage(new Image(stream));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
