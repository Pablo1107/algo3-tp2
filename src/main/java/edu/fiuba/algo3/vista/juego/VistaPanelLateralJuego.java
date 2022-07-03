package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.controlador.ControladorBotonReiniciarJuego;
import edu.fiuba.algo3.controlador.ControladorBotonVolverAlInicio;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.TituloJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaPanelLateralJuego extends VBox {
    private static final int TAMANIO_TITULO = 36;

    private ControladorCambioDePantallas controladorCambioPantallas;
    private Text contadorPuntajeActual;

    public VistaPanelLateralJuego(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.contadorPuntajeActual = this.crearContadorPuntajeActual();
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("panel-lateral-juego");
        this.getStyleClass().add("lista-vertical");

        ContenedorBotones contenedorBotones = new ContenedorBotones();
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Reiniciar", new ControladorBotonReiniciarJuego(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Volver", new ControladorBotonVolverAlInicio(this.controladorCambioPantallas)));

        this.getChildren().add(new TituloJuego(TAMANIO_TITULO));
        this.getChildren().add(this.contadorPuntajeActual);
        this.getChildren().add(contenedorBotones);
    }

    private Button crearBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        return boton;
    }

    private Text crearContadorPuntajeActual() {
        int movimientosActualesJugador = this.obtenerMovimientosActualesJugador();
        String formato = String.format("Movimientos Actuales: %s", movimientosActualesJugador);
        return new Text(formato);
    }

    public void actualizarContadorPuntajeActual() {
        this.contadorPuntajeActual.setText(String.valueOf(this.obtenerMovimientosActualesJugador()));
    }

    private int obtenerMovimientosActualesJugador() {
        return ModeloJuego.getInstancia().getJugador().getMovimientos();
    }
}
