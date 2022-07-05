package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vista.juego.VistaPanelLateralJuego;
import edu.fiuba.algo3.vista.juego.VistaPartida;

public class ControladorPostTurnoJugador {
    private final ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorPostTurnoJugador(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    public void actualizarVista(VistaPartida vistaPartida, VistaPanelLateralJuego vistaPanelLateralJuego) {
        vistaPartida.renderizar();
        vistaPanelLateralJuego.actualizarContadorPuntajeActual();
    }

    public void finalizarTurno() {
        if (this.juegoHaFinalizado()) {
            this.controladorCambioPantallas.cargarPantallaResultados();
        }
    }

    private boolean juegoHaFinalizado() {
        return !Juego.getInstancia().hayPartidaEnCurso();
    }
}
