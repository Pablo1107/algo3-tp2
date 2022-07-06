package edu.fiuba.algo3.vista.partidas;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.juego.VistaEntradaListadoResultadosPartida;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VistaListadoResultadosPartida extends HBox {
    public VistaListadoResultadosPartida() {
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("contenedor-resultados-partida");

        List<Jugador> listadoJugadores = Juego.getInstancia().getPartidaActual().getListadoJugadores();
        List<VistaEntradaListadoResultadosPartida> listadoResultados = new ArrayList<>();

        for(Jugador jugador : listadoJugadores) {
            VistaEntradaListadoResultadosPartida resultadoJugador = new VistaEntradaListadoResultadosPartida(jugador);
            this.getChildren().add(resultadoJugador);
            listadoResultados.add(resultadoJugador);
        }

        VistaEntradaListadoResultadosPartida resultadoGanador = this.entradaResultadoGanador(listadoResultados);
        resultadoGanador.setImagenResultadoGanador();
    }

    private VistaEntradaListadoResultadosPartida entradaResultadoGanador(List<VistaEntradaListadoResultadosPartida> listadoResultados) {
        return Collections.min(listadoResultados, Comparator.comparing(resultado -> resultado.getResultadoJugador()));
    }
}
