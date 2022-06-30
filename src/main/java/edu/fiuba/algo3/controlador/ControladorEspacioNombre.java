package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.util.List;

public class ControladorEspacioNombre implements EventHandler<ActionEvent> {

    private TextField nombre;
    private ControladorCambioDePantallas controladorCambioPantallas;

    public ControladorEspacioNombre(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        List<Partida> resultados = ModeloJuego.getInstancia().getPartidas();
        resultados.get(resultados.size()-1).setNombre(nombre.getText());
        this.controladorCambioPantallas.cargarPantallaPuntajes();
    }

    public void setNombre(TextField nombre) {
        this.nombre = nombre;
    }
}
