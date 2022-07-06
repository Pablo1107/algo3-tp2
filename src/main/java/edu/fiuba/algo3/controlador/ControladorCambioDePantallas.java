package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaInformacionDelProyecto;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaAyuda;
import edu.fiuba.algo3.vista.inicio.VistaPantallaInicio;
import edu.fiuba.algo3.vista.juego.VistaPantallaRegistrarJugadores;
import edu.fiuba.algo3.vista.juego.VistaPantallaPartida;
import edu.fiuba.algo3.vista.partidas.VistaPantallaResultados;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ControladorCambioDePantallas {

    private final int MIN_HEIGHT = 1080;
    private final int MIN_WIDTH = 1920;
    private final Stage stage;

    public ControladorCambioDePantallas(Stage stage) {
        this.stage = stage;
    }

    public void cargarPantallaInicio() {
        this.cambiarPantalla(new VistaPantallaInicio(this));
    }

    public void cargarPantallaRegistrarJugadores() {
        this.cambiarPantalla(new VistaPantallaRegistrarJugadores(this));
    }

    public void cargarPantallaPartida() {
        VistaPantallaPartida pantalla = new VistaPantallaPartida(this);
        Scene scene = new Scene(pantalla);
        App.aplicarEstilos(scene);
        pantalla.iniciarEventLoop(scene);
        this.stage.setScene(scene);
    }

    public void cargarPantallaAyuda(boolean estaJugando) {
        this.cambiarPantalla(new VistaPantallaAyuda(this, estaJugando));
    }

    public void cargarPantallaInformacionDelProyecto() {
        this.cambiarPantalla(new VistaPantallaInformacionDelProyecto(this));
    }

    public void cargarPantallaResultados() {
        this.cambiarPantalla(new VistaPantallaResultados(this));
    }

    private void cambiarPantalla(Parent pantalla) {
        Scene scene = new Scene(pantalla, MIN_WIDTH, MIN_HEIGHT);
        App.aplicarEstilos(scene);
        this.stage.setMinWidth(MIN_WIDTH);
        this.stage.setMinHeight(MIN_HEIGHT);
        this.stage.setScene(scene);
    }

    public void alternarPantallaCompleta(MenuItem botonAlternarPantallaCompleto) {
        this.stage.setFullScreen(!this.stage.isFullScreen());

        String opcionAlternarPantallaCompleta = this.stage.isFullScreen() ? "Minimizar" : "Maximizar";

        botonAlternarPantallaCompleto.setText(opcionAlternarPantallaCompleta);
        this.stage.show();
    }
}
