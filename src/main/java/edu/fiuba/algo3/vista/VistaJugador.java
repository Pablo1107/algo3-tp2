package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class VistaJugador extends Renderizable {
    private static final String IMAGEN_MOTO = "src/main/resources/img/vehiculos/moto.png";
    private static final String IMAGEN_AUTO = "src/main/resources/img/vehiculos/auto.png";
    private static final String IMAGEN_CUATROXCUATRO = "src/main/resources/img/vehiculos/cuatroxcuatro.png";

    private Jugador jugador;

    public VistaJugador(Jugador jugador) {
        super();
        this.jugador = jugador;
        this.ajustarEscala();
        this.cargarImagen(IMAGEN_MOTO);
    }

    public void actualizar() {
        Posicion posicionJugador = this.jugador.getPosicion();
        this.setX(posicionJugador.getX() * VistaJuego.FACTOR_ESCALA);
        this.setY(posicionJugador.getY() * VistaJuego.FACTOR_ESCALA);
        this.renderizar();
    }

    protected void renderizar() {
        Vehiculo vehiculoActual = jugador.getVehiculo();
        if (vehiculoActual instanceof Moto) {
            this.cargarImagen(IMAGEN_MOTO);
        } else if (vehiculoActual instanceof Auto) {
            this.cargarImagen(IMAGEN_AUTO);
        } else if (vehiculoActual instanceof CuatroXCuatro) {
            this.cargarImagen(IMAGEN_CUATROXCUATRO);
        }
    }

    public static class VistaJuego {
        public final static double FACTOR_ESCALA = 100;

        private ControladorJuego controlador;
        private ModeloJuego modelo;

        private Group root;
        private VistaJugador vistaJugador;
        private VistaMapa vistaMapa;

        public VistaJuego(ControladorJuego controlador, ModeloJuego modelo) {
            this.controlador = controlador;
            this.modelo = modelo;
            this.root = new Group();

            this.vistaMapa = new VistaMapa(this.modelo.getMapa());
            this.vistaJugador = new VistaJugador(this.modelo.getJugador());

            this.inicializar();
        }

        private void inicializar() {
            this.root.getChildren().add(this.vistaMapa);
            this.root.getChildren().add(this.vistaJugador);

            // Esto es solo para probar el cambio de vehiculo mientras no ponemos
            // los obstaculos.
            Button button = new Button("CAMBIAR VEHICULO");
            button.setOnAction(event -> {
                this.modelo.getJugador().cambiarVehiculo();
                this.vistaJugador.actualizar();
            });
            this.root.getChildren().add(button);
        }

        public Parent asParent() {
            return this.root;
        }

        public void inicializarMovimiento(Scene scene) {
            scene.setOnKeyPressed(evento -> {
                this.controlador.mover(evento);
                this.actualizar();
            });
        }

        private void actualizar() {
            this.vistaJugador.actualizar();
        }
    }
}
