package edu.fiuba.algo3.vista.inicio;

import edu.fiuba.algo3.controlador.ControladorBotonAyuda;
import edu.fiuba.algo3.controlador.ControladorBotonCerrarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonInformacionDelProyecto;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class VistaBarraDeMenu extends MenuBar {
    private final ControladorCambioDePantallas controladorCambioDePantallas;

    public VistaBarraDeMenu(ControladorCambioDePantallas controladorCambioDePantallas) {
        this.controladorCambioDePantallas = controladorCambioDePantallas;
        this.inicializarVista();
    }

    private void inicializarVista() {
        MenuItem opcionAlternarPantallaCompleta = new MenuItem("Maximizar");
        opcionAlternarPantallaCompleta.setOnAction(evento -> {
            this.controladorCambioDePantallas.alternarPantallaCompleta(opcionAlternarPantallaCompleta);
        });

        MenuItem opcionAyudaJuego = this.crearOpcionConControlador("Ayuda", new ControladorBotonAyuda(this.controladorCambioDePantallas, true));
        MenuItem opcionInformacionJuego = this.crearOpcionConControlador("Informacion", new ControladorBotonInformacionDelProyecto(this.controladorCambioDePantallas));
        MenuItem opcionSalirJuego = this.crearOpcionConControlador("Salir", new ControladorBotonCerrarJuego());

        this.getMenus().add(this.crearMenuConOpcion(opcionAlternarPantallaCompleta));
        this.getMenus().add(this.crearMenuConOpcion(opcionAyudaJuego));
        this.getMenus().add(this.crearMenuConOpcion(opcionInformacionJuego));
        this.getMenus().add(this.crearMenuConOpcion(opcionSalirJuego));
    }

    private MenuItem crearOpcionConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        MenuItem opcionMenu = new MenuItem(contenido);
        opcionMenu.setOnAction(controlador);
        return opcionMenu;
    }

    private Menu crearMenuConOpcion(MenuItem opcion) {
        Menu menu = new Menu(opcion.getText());
        menu.getItems().add(opcion);
        return menu;
    }
}
