package edu.fiuba.algo3.vista.puntajes;

import java.util.List;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaListadoPuntajes extends VBox {
    public VistaListadoPuntajes() {
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("contendor-listado-puntajes");

        List<Partida> resultados = ModeloJuego.getInstancia().getPartidas();
        for (Partida resultado : resultados) {
            this.getChildren().add(crearEntradaPuntaje(resultado));
        }
    }

    private Text crearEntradaPuntaje(Partida resultado) {
        String mensaje = String.format("Puntaje: %s puntos", resultado.getPuntaje());
        return new Text(mensaje);
    }
}
