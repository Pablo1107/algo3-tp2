package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class ControladorPantallaChica implements EventHandler<ActionEvent> {
    private final ControladorCambioDePantallas controlador;
    private final MenuItem opcionPantallaChica;
    private final MenuItem opcionPantallaCompleta;

    public ControladorPantallaChica(ControladorCambioDePantallas controlador, MenuItem opcionPantallaChica, MenuItem opcionPantallaCompleta) {
        this.controlador = controlador;
        this.opcionPantallaChica = opcionPantallaChica;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
        this.controlador.deshabilitarBotones(this.opcionPantallaChica, this.opcionPantallaCompleta);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.controlador.reducirPantalla(this.opcionPantallaChica, this.opcionPantallaCompleta);
    }
}
