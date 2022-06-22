package edu.fiuba.algo3.vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaJugador extends ImageView {
    private static final String ARCHIVO_IMAGEN = "src/main/java/edu/fiuba/algo3/vista/recursos/jugador.png";
    private static final Posicion POSICION_INICIAL = new Posicion(0, 0);
    private static final Vehiculo VEHICULO_INICIAL = new Moto();
    private static final int FACTOR_ESCALA_COORDENADAS = 10;

    private Jugador jugador;

    private VistaJugador(Image image, Jugador jugador) {
        super(image);
        this.jugador = jugador;
    }

    public static VistaJugador crear() {
        try {
            FileInputStream archivoImage = new FileInputStream(VistaJugador.ARCHIVO_IMAGEN);
            Jugador jugador = new Jugador(VistaJugador.POSICION_INICIAL, VistaJugador.VEHICULO_INICIAL);
            return new VistaJugador(new Image(archivoImage), jugador);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Ahora que lo pienso todo esto no deberia ser reponsabilidad del controller????
    // Bueno por ahora lo dejo asi para que funcione mas que nada.
    public void moverDerecha(Mapa mapa) {
        this.jugador.avanzar(new Direccion(1, 0), mapa);
        this.actualizarPosicion();
    }

    public void moverIzquierda(Mapa mapa) {
        this.jugador.avanzar(new Direccion(-1, 0), mapa);
        this.actualizarPosicion();
    }

    public void moverArriba(Mapa mapa) {
        this.jugador.avanzar(new Direccion(0, -1), mapa);
        this.actualizarPosicion();
    }

    public void moverAbajo(Mapa mapa) {
        this.jugador.avanzar(new Direccion(0, 1), mapa);
        this.actualizarPosicion();
    }

    private void actualizarPosicion() {
        Posicion posicionActualJugador = this.jugador.getPosicion();
        this.setX(posicionActualJugador.getX() * VistaJugador.FACTOR_ESCALA_COORDENADAS);
        this.setY(posicionActualJugador.getY() * VistaJugador.FACTOR_ESCALA_COORDENADAS);
    }
}
