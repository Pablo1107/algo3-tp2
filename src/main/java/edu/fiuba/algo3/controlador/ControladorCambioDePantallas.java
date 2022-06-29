package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.pantallas.VistaPantallaInicio;
import edu.fiuba.algo3.vista.pantallas.VistaPantallaAyuda;
import edu.fiuba.algo3.vista.pantallas.VistaPantallaJuego;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorCambioDePantallas {
    private Stage stage;

    public ControladorCambioDePantallas(Stage stage) {
        this.stage = stage;
    }

    public void cargarPantallaInicio() {
        this.cambiarPantalla(new VistaPantallaInicio(this));
    }

    // TODO: Aca podriamos unificar todo realmente.
    public void cargarPantallaJuego() {
        // TODO: Hay que ver si realmente reiniciamos el juego o simplemente creamos uno nuevo.
        ModeloJuego modelo = ModeloJuego.obtenerInstancia();
        modelo.reiniciar();
        VistaPantallaJuego pantalla = new VistaPantallaJuego(modelo, this);
        Scene scene = new Scene(pantalla);
        App.aplicarEstilos(scene);
        pantalla.inicializarMovimiento(scene);
        this.stage.setScene(scene);
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
