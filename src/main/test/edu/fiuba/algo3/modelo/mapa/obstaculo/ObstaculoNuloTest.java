package edu.fiuba.algo3.modelo.mapa.obstaculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.mapa.elemento.ElementoNulo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

public class ObstaculoNuloTest {
	@Test
	public void laPenalizacionDeUnObstaculoNuloParaUnaMotoEsCero() {
        // 		ElementoNulo obstaculo = new ElementoNulo();
        // 
        // 		assertEquals(0, obstaculo.aplicarPenalizacion(new Moto()));
	}

	@Test
	public void laPenalizacionDeUnObstaculoNuloParaUnAutoEsCero() {
        // 		ElementoNulo obstaculo = new ElementoNulo();
        // 
        // 		assertEquals(0, obstaculo.aplicarPenalizacion(new Auto()));
	}

	@Test
	public void laPenalizacionDeUnObstaculoNuloParaUnCuatroXCuatroEsCero() {
        // 		ElementoNulo obstaculo = new ElementoNulo();
        // 
        // 		assertEquals(0, obstaculo.aplicarPenalizacion(new CuatroXCuatro()));
	}
}
