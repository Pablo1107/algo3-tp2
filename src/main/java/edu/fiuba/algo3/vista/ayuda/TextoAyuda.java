package edu.fiuba.algo3.vista.ayuda;

import javafx.scene.control.Label;

public class TextoAyuda extends Label {
    public TextoAyuda() {
        super("El juego consiste en llegar a la meta en la menor cantidad de movimientos posible\n" +
                "Se tiene una moto, un auto o una 4x4 las cuales tienen distintos comportamientos segun el elemento que pisen\n" +
                "Hay tres tipos de obstaculos que imponen penalizaciones sobre el jugador y tres tipos de sorpresas\n" +
                "Dentro de los obstaculos se encuentran los pozos, los piquetes y los controles policiales\n" +
                "Dentro de las sorpresas se encuentran las favorables, las desfavorables y el cambio de vehiculo\n" +
                "Los pozos imponen pensalizacion de 3 turnos a los autos y las motos y de 2 turnos a la 4x4 luego de pasar por 3 pozos\n" +
                "El piquete no deja pasar a los autos y 4x4 pero las motos pueden pasar con 2 penalizaciones\n" +
                "El control policial penaliza con ciertas probabilidades, 0.3 para las 4x4, 0.5 para los autos y 0.8 para las motos\n" +
                "La sorpresa vaforable resta el 20% de los movimientos\n" +
                "La sorpresa desfavorable suma el 25% de los movimientos\n" +
                "La sorpresa cambio de vehiculo cambia el vehiculo\n");
    }

}