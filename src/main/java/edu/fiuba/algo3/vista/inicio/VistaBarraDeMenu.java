package edu.fiuba.algo3.vista.inicio;

import edu.fiuba.algo3.controlador.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class VistaBarraDeMenu extends MenuBar {

    public VistaBarraDeMenu(ControladorCambioDePantallas controlador){
        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionIniciarJuego = new MenuItem("Iniciar Juego");
        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerda de...");
        MenuItem opcionAyudaJuego = new MenuItem("Ayuda juego");

        opcionIniciarJuego.setOnAction(new ControladorBotonIniciarJuego(controlador));
        opcionSalir.setOnAction(new ControladorBotonCerrarJuego());
        opcionAyudaJuego.setOnAction(new ControladorBotonAyuda(controlador, false));
        opcionAcercaDe.setOnAction(new ControladorBotonAcercaDe(controlador));
        MenuItem opcionPantallaChica = new MenuItem("Miniatura");
        MenuItem opcionPantallaCompleta = new MenuItem("Pantalla Completa");
        opcionPantallaCompleta.setOnAction(new ControladorPantallaCompleta(controlador, opcionPantallaCompleta, opcionPantallaChica));
        opcionPantallaChica.setOnAction(new ControladorPantallaChica(controlador, opcionPantallaChica, opcionPantallaCompleta));

        menuArchivo.getItems().addAll(opcionIniciarJuego, opcionSalir);
        menuVer.getItems().addAll(opcionPantallaChica, opcionPantallaCompleta);
        menuAyuda.getItems().addAll(opcionAcercaDe, opcionAyudaJuego);

        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda);
    }
}
