package edu.fiuba.algo3.vista.partidas;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class VistaListadoResultados extends VBox {
    public VistaListadoResultados() {
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("lista-vertical");

        List<Jugador> listadoJugadores = Juego.getInstancia().getPartidaActual().getListadoJugadores();

        for(Jugador jugador : listadoJugadores) {
            this.getChildren().add(this.crearEntradaResultadoJugador(jugador));
        }
    }

    private Text crearEntradaResultadoJugador(Jugador jugador) {
        String formato = String.format("%s: %s Movimientos", jugador.getNombre(), jugador.getMovimientos());
        return new Text(formato);
    }
}
