package edu.fiuba.algo3.vista.ayuda;

import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import edu.fiuba.algo3.controlador.ControladorVolverAPantallaPartida;

public class VistaPantallaAyudaDuranteElJuego extends VistaPantallaAyuda {
    public VistaPantallaAyudaDuranteElJuego(ControladorCambioDePantallas controladorCambioDePantallas) {
        super(controladorCambioDePantallas);
    }

    protected void agregarBotonRegresoAPantallaAnterior() {
        this.agregarBotonConControlador("Volver", new ControladorVolverAPantallaPartida(this.controladorCambioPantallas));
    }
}
