package edu.fiuba.algo3.vista.partidas;

import edu.fiuba.algo3.controlador.ControladorHistorialPartidas;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.juego.VistaEntradaListadoResultadosPartida;
import javafx.scene.layout.HBox;

import java.util.*;

public class VistaListadoResultadosPartida extends HBox {
    private final ControladorHistorialPartidas controladorRanking;

    public VistaListadoResultadosPartida(ControladorHistorialPartidas controladorRanking) {
        this.controladorRanking = controladorRanking;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("contenedor-resultados-partida");

        List<Jugador> listadoJugadores = Juego.getInstancia().getPartidaActual().getListadoJugadores();
        List<VistaEntradaListadoResultadosPartida> listadoResultados = new ArrayList<>();

        HashMap<String, Long> ranking = controladorRanking.cargarRanking();
        for (Jugador jugador : listadoJugadores) {
            ranking.put(jugador.getNombre(), Long.valueOf(jugador.getMovimientos()));
        }

        controladorRanking.guardarRanking(ranking);

        for (Map.Entry<String, Long> set : ranking.entrySet()) {
            VistaEntradaListadoResultadosPartida resultadoJugador = new VistaEntradaListadoResultadosPartida(set.getKey(), set.getValue());
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
