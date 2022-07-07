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
    private static final int MAXIMO_RESULTADOS_MOSTRADOS = 5;

    private final ControladorHistorialPartidas controladorHistorialPartidas;

    private class RegistroPartida {
        private final String nombreJugador;
        private final Long resultadoJugador;

        public RegistroPartida(String nombreJugador, Long resultadoJugador) {
            this.nombreJugador = nombreJugador;
            this.resultadoJugador = resultadoJugador;
        }

        public String getNombreJugador() {
            return this.nombreJugador;
        }

        public Long getResultadoJugador() {
            return this.resultadoJugador;
        }
    }

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

        List<RegistroPartida> registrosPartidas = new ArrayList<>();

        for (Map.Entry<String, Long> set : historialPartidas.entrySet()) {
            registrosPartidas.add(new RegistroPartida(set.getKey(), set.getValue()));
        }

        registrosPartidas.sort(Comparator.comparing(resultado -> resultado.getResultadoJugador()));

        int i = 0;
        for (RegistroPartida r : registrosPartidas) {
            if (i >= MAXIMO_RESULTADOS_MOSTRADOS) {
                break;
            }

            VistaEntradaListadoResultadosPartida resultadoJugador = new VistaEntradaListadoResultadosPartida(r.getNombreJugador(), r.getResultadoJugador());
            this.getChildren().add(resultadoJugador);
            listadoResultados.add(resultadoJugador);
            i++;
        }

        VistaEntradaListadoResultadosPartida resultadoGanador = this.entradaResultadoGanador(listadoResultados);
        resultadoGanador.setImagenResultadoGanador();
    }

    private VistaEntradaListadoResultadosPartida entradaResultadoGanador(List<VistaEntradaListadoResultadosPartida> listadoResultados) {
        return Collections.min(listadoResultados, Comparator.comparing(resultado -> resultado.getResultadoJugador()));
    }
}
