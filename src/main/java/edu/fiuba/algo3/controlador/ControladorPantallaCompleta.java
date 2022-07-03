package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ControladorPantallaCompleta implements EventHandler<ActionEvent> {

    private ControladorCambioDePantallas controlador;
    private MenuItem opcionPantallaCompleta;

    public ControladorPantallaCompleta(ControladorCambioDePantallas controlador, MenuItem opcionPantallaCompleta) {
        this.controlador = controlador;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = this.controlador.getStage();
        if(!stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            stage.show();
        }
    }
}
