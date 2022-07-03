package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorMusica implements EventHandler<ActionEvent> {
    private String direccion;

    public void ControladorMusica(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //silenciar o activar musica
    }

}
