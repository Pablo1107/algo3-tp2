package edu.fiuba.algo3.vista.ayuda;

import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.controlador.ControladorVolverAPantallaDeInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaPantallaAyuda extends VBox {
    protected final ControladorCambioDePantallas controladorCambioPantallas;

    public VistaPantallaAyuda(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.inicializarVista();
    }

    protected void inicializarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");
        this.setWidth(300);

        this.getChildren().add(this.crearSeccionObjetivoDelJuego());
        this.getChildren().add(this.crearSeccionObstaculos());
        this.getChildren().add(this.crearSeccionSorpresas());

        this.agregarBotonRegresoAPantallaAnterior();
    }

    protected void agregarBotonRegresoAPantallaAnterior() {
        this.agregarBotonConControlador("Volver", new ControladorVolverAPantallaDeInicio(this.controladorCambioPantallas));
    }

    protected void agregarBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        this.getChildren().add(boton);
    }

    private VistaSeccionAyuda crearSeccionObjetivoDelJuego() {
        String contenido = "El juego consiste en llegar a la meta en la menor cantidad de movimientos posible.\n" +
            "Se tiene una moto, un auto o una 4x4 las cuales tienen distintos comportamientos segun el elemento que pisen" +
            "Hay tres tipos de obstaculos que imponen penalizaciones sobre el jugador y tres tipos de sorpresas";
        return new VistaSeccionAyuda("Objetivo del Juego", contenido);
    }

    private VistaSeccionAyuda crearSeccionObstaculos() {
        String contenido = "Estan los pozos, los piquetes y los controles policiales\n" + 
            "Los pozos imponen pensalizacion de 3 turnos a los autos y las motos y de 2 turnos a la 4x4 luego de pasar por 3 pozos" +
            "El piquete no deja pasar a los autos y 4x4 pero las motos pueden pasar con 2 penalizaciones" +
            "El control policial penaliza con ciertas probabilidades, 0.3 para las 4x4, 0.5 para los autos y 0.8 para las motos";
        return new VistaSeccionAyuda("Obstaculos", contenido);
    }

    private VistaSeccionAyuda crearSeccionSorpresas() {
        String contenido = "Dentro de las Sorpresas se encuentran las Favorables, las Desfavorables y el Cambio de Vehiculo \n" +
            "La Sorpresa Favorable resta el 20% de los movimientos" +
            "La Sorpresa Desfavorable suma el 25% de los movimientos" +
            "La Sorpresa Cambio de Vehiculo cambia el vehiculo";
        return new VistaSeccionAyuda("Sorpresas", contenido);
    }
}
