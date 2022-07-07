package edu.fiuba.algo3.controlador;

import com.google.gson.JsonObject;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Partida;

public class ControladorExportarPartidas {
    public static final String ARCHIVO_PARTIDAS = "src/main/resources/edu/fiuba/algo3/partidas.json";

    public void guardarUltimaPartida() {
        Partida ultimaPartida = Juego.getInstancia().getPartidaActual();

        if (ultimaPartida.estaEnCurso()) {
            return;
        }

        JsonObject jsonPartida = this.crearJSONPartida(ultimaPartida);
    }

    private JsonObject crearJSONPartida(Partida partida) {
        JsonObject jsonPartida = new JsonObject();

        jsonPartida.addProperty("nombreJugador", partida.getJugadorEnTurno().getNombre());

        return jsonPartida;
    }
}
