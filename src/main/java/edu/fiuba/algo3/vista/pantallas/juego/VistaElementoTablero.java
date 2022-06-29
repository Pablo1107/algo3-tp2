package edu.fiuba.algo3.vista.pantallas.juego;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class VistaElementoTablero extends ImageView {
    protected void ajustarEscalaVista() {
        this.setFitWidth(VistaPantallaJuego.FACTOR_ESCALA);
        this.setFitHeight(VistaPantallaJuego.FACTOR_ESCALA);
    }

    public abstract void actualizarVista();

    protected abstract void cambiarImagenVista();

    protected void cargarRecursoImagen(String archivoImagen) {
        try {
            FileInputStream stream = new FileInputStream(archivoImagen);
            this.setImage(new Image(stream));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
