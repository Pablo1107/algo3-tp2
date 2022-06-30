package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaAyuda;
import edu.fiuba.algo3.vista.inicio.VistaPantallaInicio;
import edu.fiuba.algo3.vista.juego.VistaPantallaJuego;
import edu.fiuba.algo3.vista.puntajes.VistaNombresPuntaje;
import edu.fiuba.algo3.vista.puntajes.VistaPantallaPuntajes;
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
        ModeloJuego modelo = ModeloJuego.getInstancia();
        modelo.reiniciarJuego();

        VistaPantallaJuego pantalla = new VistaPantallaJuego(modelo, this);
        Scene scene = new Scene(pantalla);
        App.aplicarEstilos(scene);

        pantalla.inicializarMovimiento(scene);
        this.stage.setScene(scene);
    }

    public void cargarPantallaAyuda() {
        this.cambiarPantalla(new VistaPantallaAyuda(this));
    }
    
    public void cargarPantallaPuntajes() {
        this.cambiarPantalla(new VistaPantallaPuntajes(this));
    }

    public void cargarPantallaNombres() {
        this.cambiarPantalla(new VistaNombresPuntaje(this));
    }

    private void cambiarPantalla(Parent pantalla) {
        Scene scene = new Scene(pantalla);
        App.aplicarEstilos(scene);
        this.stage.setScene(scene);
    }

}
