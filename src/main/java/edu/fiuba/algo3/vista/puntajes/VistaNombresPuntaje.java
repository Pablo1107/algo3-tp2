package edu.fiuba.algo3.vista.puntajes;

import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.controlador.ControladorEspacioNombre;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VistaNombresPuntaje extends VBox {

    private final ControladorCambioDePantallas controladorCambioPantallas;

    public VistaNombresPuntaje(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("nombre-puntaje");

        TextField espacioNombre = this.crearEspacioNombre(new ControladorEspacioNombre(this.controladorCambioPantallas));
        this.getChildren().add(espacioNombre);
    }

    private TextField crearEspacioNombre(ControladorEspacioNombre controlador) {
        TextField nombre = new TextField();
        controlador.setNombre(nombre);
        nombre.setOnAction(controlador);
        return nombre;
    }


}
