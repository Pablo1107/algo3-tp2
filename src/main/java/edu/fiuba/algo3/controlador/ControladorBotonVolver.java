package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonVolver implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;
    private boolean estaJugando;

    public ControladorBotonVolver(ControladorCambioDePantallas controladorCambioPantallas, boolean estaJugando) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.estaJugando = estaJugando;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.estaJugando) {
            this.controladorCambioPantallas.cargarPantallaPartidaEnCurso();
        } else {
            this.controladorCambioPantallas.cargarPantallaInicio();
        }
    }
}
