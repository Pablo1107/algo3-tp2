package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.modelo.ModeloJuego;
import edu.fiuba.algo3.vista.VistaInicio;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private Stage stage;
    @Override
    public void start(Stage primaryStage) {
        //ModeloJuego modelo = new ModeloJuego();
        //ControladorJuego controlador = new ControladorJuego(modelo);
        //VistaJuego root = new VistaJuego(controlador, modelo);

        this.stage = primaryStage;

        VistaInicio rootInicio = new VistaInicio();
        Scene scene = new Scene(rootInicio.asParent(), 1250, 750);

        rootInicio.presionarBotones(this.stage);

        //root.inicializarMovimiento(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
