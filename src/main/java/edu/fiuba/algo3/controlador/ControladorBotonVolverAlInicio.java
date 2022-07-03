package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonVolverAlInicio implements EventHandler<ActionEvent> {
    private ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorBotonVolverAlInicio(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.controladorCambioPantallas.cargarPantallaInicio();
    }
}
