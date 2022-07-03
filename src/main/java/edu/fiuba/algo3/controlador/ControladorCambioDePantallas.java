package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaAcercaDe;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaAyuda;
import edu.fiuba.algo3.vista.inicio.VistaPantallaInicio;
import edu.fiuba.algo3.vista.juego.VistaPantallaJuego;
import edu.fiuba.algo3.vista.partidas.VistaPantallaPartidas;
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

    public void cargarPantallaAcercaDe() {
        this.cambiarPantalla(new VistaPantallaAcercaDe(this));
    }

    public void cargarPantallaPartidas() {
        this.cambiarPantalla(new VistaPantallaPartidas(this));
    }

    private void cambiarPantalla(Parent pantalla) {
        Scene scene = new Scene(pantalla);
        App.aplicarEstilos(scene);
        this.stage.setScene(scene);
    }


    public Stage getStage() {
        return this.stage;
    }
}
