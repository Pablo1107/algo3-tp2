package edu.fiuba.algo3.vista.ayuda;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaSeccionAyuda extends VBox {
    private Text titulo;
    private Text contenido;

    public VistaSeccionAyuda(String titulo, String contenido) {
        this.titulo = new Text(titulo);
        this.contenido = new Text(contenido);
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("seccion-ayuda");
        this.titulo.getStyleClass().add("titulo-seccion-ayuda");
        this.contenido.setWrappingWidth(750);

        this.getChildren().addAll(this.titulo, this.contenido);
    }
}
