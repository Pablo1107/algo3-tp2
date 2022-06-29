package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaPantallaInicio;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorCambioPantallas {
    private Stage stage;

    public ControladorCambioPantallas(Stage stage) {
        this.stage = stage;
    }

    public void cargarPantallaInicio() {
        Parent pantalla = new VistaPantallaInicio(this);
        this.stage.setScene(new Scene(pantalla));
    }

    public void cargarPantallaJuego() {
        Parent pantalla = new VistaPantallaInicio(this);
        this.stage.setScene(new Scene(pantalla));
    }
}
