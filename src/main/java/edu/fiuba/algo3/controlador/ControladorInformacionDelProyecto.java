package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorInformacionDelProyecto implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorInformacionDelProyecto(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.controladorCambioPantallas.cargarPantallaInformacionDelProyecto();
    }
}
