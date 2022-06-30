package edu.fiuba.algo3.vista;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Sonido {

    public static void reproducirSonido() {
        final String NOMBRE_ARCHIVO = "src/main/resources/sfx/pisar_pozo.mp3";
        File archivo = new File(NOMBRE_ARCHIVO);
        System.out.println(archivo.toURI().toString());
        AudioClip plonkSound = new AudioClip(archivo.toURI().toString());
        plonkSound.play();
    }
}
