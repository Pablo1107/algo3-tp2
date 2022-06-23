package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        ModeloJuego modelo = new ModeloJuego();
        ControladorJuego controlador = new ControladorJuego(modelo);
        VistaJuego root = new VistaJuego(controlador, modelo);

        Scene scene = new Scene(root.asParent());
        root.inicializarMovimiento(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
