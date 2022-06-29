package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.pantallas.VistaPantallaInicio;
import edu.fiuba.algo3.vista.pantallas.VistaPantallaAyuda;
import edu.fiuba.algo3.vista.pantallas.VistaPantallaJuego;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorCambioPantallas {
    private Stage stage;

    public ControladorCambioPantallas(Stage stage) {
        this.stage = stage;
    }

    public void cargarPantallaInicio() {
        this.cambiarPantalla(new VistaPantallaInicio(this));
    }

    public void cargarPantallaJuego() {
        this.cambiarPantalla(new VistaPantallaJuego(ModeloJuego.obtenerInstancia(), this));
    }

    public void cargarPantallaAyuda() {
        this.cambiarPantalla(new VistaPantallaAyuda(this));
    }

    private void cambiarPantalla(Parent pantalla) {
        Scene scene = new Scene(pantalla);
        App.aplicarEstilos(scene);
        this.stage.setScene(scene);
    }
}
