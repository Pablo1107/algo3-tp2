package edu.fiuba.algo3.vista.juego;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class VistaJugador extends VistaElementoTablero {
    private static int indiceFactoryImagenesJugadorEnTurnoStatic = 0;
    private List<ImagenesJugadorFactory> imagenesJugadorFactory = new ArrayList<>() {
        {
            add(new ImagenesJugadorMessi());
            add(new ImagenesJugadorDiego());
            add(new ImagenesJugadorScaloni());
        }
    };

    private final Jugador jugador;
    private final int indiceFactoryImagenesJugadorEnTurno;

    public VistaJugador(Jugador jugador) {
        if (!(indiceFactoryImagenesJugadorEnTurnoStatic < imagenesJugadorFactory.size())) {
            indiceFactoryImagenesJugadorEnTurnoStatic = 0;
        }

        this.indiceFactoryImagenesJugadorEnTurno = indiceFactoryImagenesJugadorEnTurnoStatic++;
        this.jugador = jugador;
        this.ajustarEscalaVista();
        this.renderizar();
    }

    public void renderizar() {
        this.sincronizarConModelo();
        this.cambiarImagen();
    }

    private ImagenesJugadorFactory getFactoryImagenesEnJugadorEnTurno() {
        return imagenesJugadorFactory.get(this.indiceFactoryImagenesJugadorEnTurno);
    }

    protected void cambiarImagen() {
        Vehiculo vehiculoActualJugador = jugador.getVehiculo();
        if (vehiculoActualJugador instanceof Moto) {
            this.cargarRecursoImagen(this.getFactoryImagenesEnJugadorEnTurno().getURIImagenMoto());
        } else if (vehiculoActualJugador instanceof Auto) {
            this.cargarRecursoImagen(this.getFactoryImagenesEnJugadorEnTurno().getURIImagenAuto());
        } else if (vehiculoActualJugador instanceof CuatroXCuatro) {
            this.cargarRecursoImagen(this.getFactoryImagenesEnJugadorEnTurno().getURIImagenCuatroXCuatro());
        }
    }

    private void sincronizarConModelo() {
        Posicion posicionActualJugador = this.jugador.getPosicion();
        this.setX(posicionActualJugador.getX() * VistaPantallaJuego.FACTOR_ESCALA_PX);
        this.setY(posicionActualJugador.getY() * VistaPantallaJuego.FACTOR_ESCALA_PX);
    }
}
