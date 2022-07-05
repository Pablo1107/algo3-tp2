package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.ControladorBotonAyuda;
import edu.fiuba.algo3.controlador.ControladorReiniciarPartida;
import edu.fiuba.algo3.controlador.ControladorBotonVolver;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloPantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaPanelLateralJuego extends VBox {
    private static final int TAMANIO_TITULO = 36;

    private final ControladorCambioDePantallas controladorCambioPantallas;
    private final Text contadorPuntajeActual;

    public VistaPanelLateralJuego(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.contadorPuntajeActual = new Text(this.getValoresContadorPuntajeActual());
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("panel-lateral-juego");
        this.getStyleClass().add("lista-vertical");

        this.contadorPuntajeActual.setId("contador-puntaje-actual");

        ContenedorBotones contenedorBotones = new ContenedorBotones();

        contenedorBotones.agregarBoton(this.crearBotonConControlador("Reiniciar", new ControladorReiniciarPartida(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Volver", new ControladorBotonVolver(this.controladorCambioPantallas, false)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Ayuda", new ControladorBotonAyuda(this.controladorCambioPantallas, true)));

        this.getChildren().add(new TituloPantalla(App.TITULO_JUEGO, TAMANIO_TITULO));
        this.getChildren().add(this.contadorPuntajeActual);
        this.getChildren().add(contenedorBotones);
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }

    public String getValoresContadorPuntajeActual() {
        int movimientosActualesJugador = this.getMovimientosActualesJugador();
        return String.format("Movimientos Actuales: %s", movimientosActualesJugador);
    }

    public void actualizarContadorPuntajeActual() {
        this.contadorPuntajeActual.setText(this.getValoresContadorPuntajeActual());
    }

    private int getMovimientosActualesJugador() {
        return Juego.getInstancia().getPartidaActual().getJugadorEnTurno().getMovimientos();
    }
}
