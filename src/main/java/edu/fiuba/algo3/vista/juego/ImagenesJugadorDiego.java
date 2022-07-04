package edu.fiuba.algo3.vista.juego;

public class ImagenesJugadorDiego extends ImagenesJugadorFactory {
    private static final String IMAGEN_MOTO = "src/main/resources/img/vehiculos/moto_diego.png";
    private static final String IMAGEN_AUTO = "src/main/resources/img/vehiculos/auto_diego.png";
    private static final String IMAGEN_CUATROXCUATRO = "src/main/resources/img/vehiculos/cuatroxcuatro_diego.png";

    @Override
    public String getURIImagenMoto() {
        return IMAGEN_MOTO;
    }

    @Override
    public String getURIImagenAuto() {
        return IMAGEN_AUTO;
    }

    @Override
    public String getURIImagenCuatroXCuatro() {
        return IMAGEN_CUATROXCUATRO;
    }
}
