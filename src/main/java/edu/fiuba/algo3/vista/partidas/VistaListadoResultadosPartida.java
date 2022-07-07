package edu.fiuba.algo3.vista.partidas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.controlador.ControladorHistorialPartidas;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.juego.VistaEntradaListadoResultadosPartida;
import javafx.scene.layout.HBox;

public class VistaListadoResultadosPartida extends HBox {
    private final ControladorHistorialPartidas controladorHistorialPartidas;

    public VistaListadoResultadosPartida(ControladorHistorialPartidas controladorHistorialPartidas) {
        this.controladorHistorialPartidas = controladorHistorialPartidas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("contenedor-resultados-partida");

        List<Jugador> listadoJugadores = Juego.getInstancia().getPartidaActual().getListadoJugadores();
        List<VistaEntradaListadoResultadosPartida> listadoResultados = new ArrayList<>();

        HashMap<String, Long> historialPartidas = this.controladorHistorialPartidas.getHistorialPartidas();
        for (Jugador jugador : listadoJugadores) {
            historialPartidas.put(jugador.getNombre(), Long.valueOf(jugador.getMovimientos()));
        }

        controladorHistorialPartidas.guardarRegistroPartida(historialPartidas);

        for (Map.Entry<String, Long> set : historialPartidas.entrySet()) {
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
