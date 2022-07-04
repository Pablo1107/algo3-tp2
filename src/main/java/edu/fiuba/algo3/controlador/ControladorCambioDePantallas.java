package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaAcercaDe;
import edu.fiuba.algo3.vista.ayuda.VistaPantallaAyuda;
import edu.fiuba.algo3.vista.inicio.VistaPantallaInicio;
import edu.fiuba.algo3.vista.juego.VistaPantallaJuego;
import edu.fiuba.algo3.vista.partidas.VistaPantallaResultados;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ControladorCambioDePantallas {
    private final Stage stage;

    public ControladorCambioDePantallas(Stage stage) {
        this.stage = stage;
    }

    public void cargarPantallaInicio() {
        this.cambiarPantalla(new VistaPantallaInicio(this));
    }

    public void cargarPantallaPartida() {
        Juego.getInstancia().iniciarNuevaPartida();
        this.cargarPantallaPartidaEnCurso();
    }

    public void cargarPantallaPartidaEnCurso() {

        VistaPantallaJuego pantalla = new VistaPantallaJuego(this);

        Scene scene = new Scene(pantalla);
        App.aplicarEstilos(scene);
        pantalla.iniciarEventLoop(scene);
        this.stage.setScene(scene);
    }

    public void cargarPantallaAyuda(boolean estaJugando) {
        this.cambiarPantalla(new VistaPantallaAyuda(this, estaJugando));
    }

    public void cargarPantallaAcercaDe() {
        this.cambiarPantalla(new VistaPantallaAcercaDe(this));
    }

    public void cargarPantallaResultados() {
        this.cambiarPantalla(new VistaPantallaResultados(this));
    }

    private void cambiarPantalla(Parent pantalla) {
        Scene scene = new Scene(pantalla);
        App.aplicarEstilos(scene);
        this.stage.setScene(scene);
    }

    public void maximizarPantalla(MenuItem opcionPantallaCompleta, MenuItem opcionPantallaChica) {
        if(!this.stage.isFullScreen()) {
            this.stage.hide();
            this.stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            opcionPantallaChica.setDisable(false);
            this.stage.show();
        }
    }

    public void reducirPantalla(MenuItem opcionPantallaChica, MenuItem opcionPantallaCompleta) {
        if(this.stage.isFullScreen()) {
            this.stage.hide();
            this.stage.centerOnScreen();
            this.stage.setFullScreen(false);
            opcionPantallaChica.setDisable(true);
            opcionPantallaCompleta.setDisable(false);
            this.stage.show();
        }
    }

    public void deshabilitarBotones(MenuItem opcionPantallaChica, MenuItem opcionPantallaCompleta) {
        if(this.stage.isFullScreen()) {
            opcionPantallaCompleta.setDisable(true);
            opcionPantallaChica.setDisable(false);
        } else {
            opcionPantallaChica.setDisable(true);
            opcionPantallaCompleta.setDisable(false);
        }
    }
}
