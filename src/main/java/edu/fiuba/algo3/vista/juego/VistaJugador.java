package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class VistaJugador extends VistaElemento {
    private static int indiceFactoryImagenesJugadorEnTurnoStatic = 0;
    private final List<ImagenesJugadorFactory> imagenesJugadorFactory = new ArrayList<>() {
        {
            add(new ImagenesJugadorMessi());
            add(new ImagenesJugadorDiego());
            add(new ImagenesJugadorScaloni());
        }
    };

    private final Jugador jugador;
    private final int indiceFactoryImagenesJugadorEnTurno;

    public VistaJugador(Jugador jugador) {
        int cantidadJugadoresPartida = Juego.getInstancia().getPartidaActual().getListadoJugadores().size();
        if (!(indiceFactoryImagenesJugadorEnTurnoStatic < cantidadJugadoresPartida)) {
            indiceFactoryImagenesJugadorEnTurnoStatic = 0;
        }

        this.indiceFactoryImagenesJugadorEnTurno = indiceFactoryImagenesJugadorEnTurnoStatic++;
        this.jugador = jugador;
        this.ajustarEscalaVista();
        this.renderizar();
    }

    @Override
    public void renderizar() {
        this.sincronizarConModelo();
        this.cambiarImagen();
    }

    private ImagenesJugadorFactory getFactoryImagenesEnJugadorEnTurno() {
        return imagenesJugadorFactory.get(this.indiceFactoryImagenesJugadorEnTurno);
    }

    @Override
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
        this.setX(posicionActualJugador.getX() * VistaPantallaPartida.FACTOR_ESCALA_PX);
        this.setY(posicionActualJugador.getY() * VistaPantallaPartida.FACTOR_ESCALA_PX);
    }
}
