package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.vista.VistaModelo;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Mapa mapa = new Mapa(10, 10);
        // Si, esta medio feo, solo quiero que ande ahorita.
        new VistaModelo(mapa, stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
