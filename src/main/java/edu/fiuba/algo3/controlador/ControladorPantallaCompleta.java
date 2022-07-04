package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class ControladorPantallaCompleta implements EventHandler<ActionEvent> {

    private final ControladorCambioDePantallas controlador;
    private final MenuItem opcionPantallaCompleta;
    private final MenuItem opcionPantallaChica;

    public ControladorPantallaCompleta(ControladorCambioDePantallas controlador, MenuItem opcionPantallaCompleta, MenuItem opcionPantallaChica) {
        this.controlador = controlador;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
        this.opcionPantallaChica = opcionPantallaChica;
        this.controlador.deshabilitarBotones(this.opcionPantallaChica, this.opcionPantallaCompleta);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.controlador.maximizarPantalla(this.opcionPantallaCompleta, this.opcionPantallaChica);
    }
}
