package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.mapa.Meta;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModeloTest {

    @Test
    public void seCreaUnJuegoYSeLlegaALaMeta() {
        ModeloJuego juego = ModeloJuego.getInstancia();
        Meta meta = new Meta(new Posicion(0, 0));
        meta.chocarCon(juego.getJugador());

        assertTrue(juego.getJuegoTerminado());
    }
}
