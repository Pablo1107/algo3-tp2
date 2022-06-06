package edu.fiuba.algo3.integration;

import edu.fiuba.algo3.modelo.mapa.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Direccion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.mapa.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    @Test
    public void unaMotoSeMuevePisaPozo() {
        Mapa mapa = new Mapa(10, 10);
        Moto moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(0,0), moto);
        Pozo pozo = new Pozo();
        Direccion derecha = new Direccion(1,0);

        assertEquals(0, jugador.getPenalizaciones());

        mapa.setElementoEnPosicion(pozo, new Posicion(1,0));
        jugador.mover(derecha, mapa);

        assertEquals(3, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(2, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(1, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(0, jugador.getPenalizaciones());
    }

    @Test
    public void unAutoSeMuevePisaPozo() {
        Mapa mapa = new Mapa(10, 10);
        Auto auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(0,0), auto);
        Pozo pozo = new Pozo();
        Direccion derecha = new Direccion(1,0);

        assertEquals(0, jugador.getPenalizaciones());

        mapa.setElementoEnPosicion(pozo, new Posicion(1,0));
        jugador.mover(derecha, mapa);

        assertEquals(3, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(2, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(1, jugador.getPenalizaciones());

        jugador.mover(derecha,mapa);
        assertEquals(0, jugador.getPenalizaciones());
    }

    @Test
    public void unaCuatroXCutroAtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        Jugador jugador = new Jugador(new Posicion(0,0), cuatroXCuatro);
        Pozo pozo = new Pozo();
        Direccion derecha = new Direccion(1,0);

        assertEquals(0, jugador.getPenalizaciones());

        mapa.setElementoEnPosicion(pozo, new Posicion(1,0));
        jugador.mover(derecha, mapa);

        assertEquals(0, jugador.getPenalizaciones());
    }

    @Test
    public void unAutoSeMueveYSeEncuentraConUnPozoSeMueveDevueltaYNoPuede() {
        Mapa mapa = new Mapa(10, 10);
        Auto auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(0,0), auto);
        Pozo pozo = new Pozo();
        Direccion derecha = new Direccion(1,0);

        mapa.setElementoEnPosicion(pozo, new Posicion(1,0));

        jugador.mover(derecha, mapa);
        assertEquals(3, jugador.getPenalizaciones());

        jugador.mover(derecha, mapa);
        assertEquals(2, jugador.getPenalizaciones());

        jugador.mover(derecha, mapa);
        assertEquals(1, jugador.getPenalizaciones());

        assertEquals(new Posicion(1, 0), jugador.getPosicion());
    }

    @Test
    public void unaMotoSeMueveSeEncuentraUnPiqueteYTieneUnaPenalizacionDeDosMovimientos() {
        Mapa mapa = new Mapa(10, 10);
        Moto moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(0, 0), moto);
        Piquete piquete = new Piquete();
        Direccion derecha = new Direccion(1, 0);

        mapa.setElementoEnPosicion(piquete, new Posicion(1,0));

        jugador.mover(derecha, mapa);
        assertEquals(2, jugador.getPenalizaciones());
    }

    @Test
    public void unAutoSeMueveSeEncuentraUnPiqueteYNoPuedeSeguirAvanzando() {
        Mapa mapa = new Mapa(10, 10);
        Auto auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(0, 0), auto);
        Piquete piquete = new Piquete();
        Direccion derecha = new Direccion(1, 0);

        mapa.setElementoEnPosicion(piquete, new Posicion(1,0));

        jugador.mover(derecha, mapa);
        assertEquals(new Posicion(0, 0), jugador.getPosicion());
    }

    @Test
    public void unAutoSeMueveSeEncuentraUnPiqueteYNoPuedeSeguirAvanzandoLuegoSeMueveHaciaArriba() {
        Mapa mapa = new Mapa(10, 10);
        Auto auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(0, 0), auto);
        Piquete piquete = new Piquete();
        Direccion derecha = new Direccion(1, 0);
        Direccion arriba = new Direccion(0, 1);

        mapa.setElementoEnPosicion(piquete, new Posicion(1,0));

        jugador.mover(derecha, mapa);
        assertEquals(new Posicion(0, 0), jugador.getPosicion());

        jugador.mover(arriba, mapa);
        assertEquals(new Posicion(0, 1), jugador.getPosicion());
    }

    @Test
    public void unaCuatroXCuatroSeMueveSeEncuentraUnPiqueteYNoPuedeSeguirAvanzando() {
        Mapa mapa = new Mapa(10, 10);
        CuatroXCuatro cuatroxcuatro = new CuatroXCuatro();
        Jugador jugador = new Jugador(new Posicion(0, 0), cuatroxcuatro);
        Piquete piquete = new Piquete();
        Direccion derecha = new Direccion(1, 0);

        mapa.setElementoEnPosicion(piquete, new Posicion(1,0));

        jugador.mover(derecha, mapa);
        assertEquals(new Posicion(0, 0), jugador.getPosicion());
    }

    //ESTA NO DEBERIA SER UNA PRUEBA POR SER UN RESULTADO PROBABILISTICO
    /*
    @Test
    public void unaMotoSeMueveYSeEncuentraUnControlPolicial() {
        Mapa mapa = new Mapa(10, 10);
        Moto moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(0, 0), moto);
        ControlPolicial controlPolicial = new ControlPolicial();
        Direccion derecha = new Direccion(1, 0);

        mapa.setElementoEnPosicion(controlPolicial, new Posicion(1, 0));

        jugador.mover(derecha, mapa);
        assertEquals(3, jugador.getPenalizaciones());
    }
     */
}
