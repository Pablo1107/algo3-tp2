package edu.fiuba.algo3.vista.historial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.controlador.ControladorHistorialPartidas;
import edu.fiuba.algo3.controlador.ControladorVolverAPantallaDeInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaPantallaRankings extends VBox {
    private static final int MAXIMO_RESULTADOS_MOSTRADOS = 10;

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

    private final ControladorCambioDePantallas controladorCambioPantallas;
    private final VBox listadoResultados;

    public VistaPantallaRankings(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.listadoResultados = new VBox();
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");
        this.listadoResultados.setId("listado-ranking");
        this.listadoResultados.getStyleClass().add("lista-vertical");

        ControladorHistorialPartidas controladorHistorialPartidas = new ControladorHistorialPartidas();
        HashMap<String, Long> historialPartidas = controladorHistorialPartidas.getHistorialPartidas();

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

            this.listadoResultados.getChildren().add(this.crearRegistroPartida(r.getNombreJugador(), r.getResultadoJugador()));
            i++;
        }

        this.getChildren().add(this.listadoResultados);
        this.agregarBotonConControlador("Volver", new ControladorVolverAPantallaDeInicio(this.controladorCambioPantallas));
    }

    private Text crearRegistroPartida(String nombreJugador, Long movimientosJugador) {
        String formato = String.format("%s: %s", nombreJugador, movimientosJugador);
        return new Text(formato);
    }

    protected void agregarBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        this.getChildren().add(boton);
    }
}
