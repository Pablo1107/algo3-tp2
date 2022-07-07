package edu.fiuba.algo3.vista.juego;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VistaEntradaListadoResultadosPartida extends VBox {
    private static final String IMAGEN_GANADOR = "src/main/resources/img/ganador.png";
    private static final String IMAGEN_PERDEDOR = "src/main/resources/img/perdedor.png";

    private final String nombre;
    private final Long movimientos;
    private final ImageView imagenResultadoPartida;

    public VistaEntradaListadoResultadosPartida(String nombre, Long movimientos) {
        this.nombre = nombre;
        this.movimientos = movimientos;
        this.imagenResultadoPartida = new ImageView(this.getRecursoImagen(IMAGEN_PERDEDOR));
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("entrada-resultado-partida");

        this.getChildren().add(this.imagenResultadoPartida);

        Text contenidoResultadoPartida = new Text(this.getInformacionResultadoPartida());
        contenidoResultadoPartida.getStyleClass().add("contenido-resultado-partida");

        this.getChildren().add(contenidoResultadoPartida);
    }

    private String getInformacionResultadoPartida() {
        return String.format("%s: %s Movimientos", this.nombre, this.movimientos);
    }

    public Long getResultadoJugador() {
        return this.movimientos;
    }

    public void setImagenResultadoGanador() {
        this.imagenResultadoPartida.setImage(this.getRecursoImagen(IMAGEN_GANADOR));
    }

    private Image getRecursoImagen(String archivoImagen) {
        try {
            FileInputStream stream = new FileInputStream(archivoImagen);
            return new Image(stream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
