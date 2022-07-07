package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.juego.Partida;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaAyuda;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaAyudaDuranteElJuego;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaInformacionDelProyecto;
import edu.fiuba.algo3.vista.inicio.VistaPantallaInicio;
import edu.fiuba.algo3.vista.juego.VistaPantallaPartida;
import edu.fiuba.algo3.vista.juego.VistaPantallaRegistrarJugadores;
import edu.fiuba.algo3.vista.partidas.VistaPantallaResultados;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ControladorCambioDePantallas {

    private static final int MIN_HEIGHT = 1080;
    private static final int MIN_WIDTH = 1920;
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

    public void cargarPantallaPartida(Partida partidaActual) {
        VistaPantallaPartida pantalla = new VistaPantallaPartida(partidaActual, this);
        Scene scene = new Scene(pantalla);
        App.aplicarEstilos(scene);
        pantalla.iniciarEventLoop(scene);
        this.stage.centerOnScreen();
        this.stage.setFullScreen(true);
        this.stage.setScene(scene);
    }

    public void cargarPantallaAyuda() {
        this.cambiarPantalla(new VistaPantallaAyuda(this));
    }

    public void cargarPantallaAyudaDuranteElJuego() {
        this.cambiarPantalla(new VistaPantallaAyudaDuranteElJuego(this));
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
