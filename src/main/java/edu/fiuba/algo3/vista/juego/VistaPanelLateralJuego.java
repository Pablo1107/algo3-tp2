package edu.fiuba.algo3.vista.juego;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.ControladorBotonAyuda;
import edu.fiuba.algo3.controlador.ControladorBotonReiniciarPartida;
import edu.fiuba.algo3.controlador.ControladorBotonVolver;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mapa.Elemento;
import edu.fiuba.algo3.modelo.mapa.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.mapa.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.mapa.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.mapa.sorpresas.Favorable;
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
    private final Text elementoChocado;

    public VistaPanelLateralJuego(ControladorCambioDePantallas controladorCambioPantallas) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.contadorPuntajeActual = new Text(this.getValoresContadorPuntajeActual());
        this.elementoChocado = new Text(this.getElementoChocado());
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.setId("panel-lateral-juego");
        this.getStyleClass().add("lista-vertical");

        this.contadorPuntajeActual.setId("contador-puntaje-actual");

        ContenedorBotones contenedorBotones = new ContenedorBotones();

        contenedorBotones.agregarBoton(this.crearBotonConControlador("Reiniciar", new ControladorBotonReiniciarPartida(this.controladorCambioPantallas)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Volver", new ControladorBotonVolver(this.controladorCambioPantallas, false)));
        contenedorBotones.agregarBoton(this.crearBotonConControlador("Ayuda", new ControladorBotonAyuda(this.controladorCambioPantallas, true)));

        this.getChildren().add(new TituloPantalla(App.TITULO_JUEGO, TAMANIO_TITULO));
        this.getChildren().add(this.contadorPuntajeActual);
        this.getChildren().add(contenedorBotones);
        this.getChildren().add(this.elementoChocado);
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

    private String getElementoChocado() {
        Elemento elemento = this.getElemento();
        return this.devolverElemento(elemento);
    }

    private String devolverElemento(Elemento e) {
        if(e instanceof Favorable) {
            return String.format("Choco con sorpresa favorable");
        }
        if(e instanceof Desfavorable) {
            return String.format("Choco con sorpresa desfavorable");
        }
        if(e instanceof CambioDeVehiculo) {
            return String.format("Choco con sorpresa cambio de vehiculo");
        }
        if(e instanceof Pozo) {
            return String.format("Choco con pozo");
        }
        if(e instanceof Piquete) {
            return String.format("Choco con piquete");
        }

        if(e instanceof ControlPolicial) {
            return String.format("Choco con control policial");
        }

        return String.format("No choco con nada");

    }

    public void actualizarContadorPuntajeActual() {
        this.contadorPuntajeActual.setText(this.getValoresContadorPuntajeActual());
    }

    public void actualizarElementoChocado() {
        this.elementoChocado.setText(this.getElementoChocado());
    }

    private int getMovimientosActualesJugador() {
        return Juego.getInstancia().getPartidaActual().getJugadorEnTurno().getMovimientos();
    }

    private Elemento getElemento() {
        return Juego.getInstancia().getPartidaActual().getElementoEnTurno();
    }
}
