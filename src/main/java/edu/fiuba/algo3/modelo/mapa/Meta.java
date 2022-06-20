package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.jugador.Jugador;

//import static edu.fiuba.algo3.modelo.Juego.corriendo;

public class Meta extends Elemento {

    public Meta(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void chocarCon(Jugador jugador) {
        //jugador.finalizoJuego();
        //corriendo = false; y hacer el atributo publico
        return;
    }
}
