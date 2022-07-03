package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TituloJuego extends Text {
    public TituloJuego(int tamanioFuente) {
        super(App.TITULO_JUEGO);
        this.inicializarVista(tamanioFuente);
    }

    private void inicializarVista(int tamanioFuente) {
        this.getStyleClass().add("titulo-pantalla");
        Font fuenteTitulo = Font.loadFont(App.class.getResource(App.FUENTE_TITULO).toExternalForm(), tamanioFuente);
        this.setFont(fuenteTitulo);
    }
}
