package edu.fiuba.algo3.vista.ayuda;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.controlador.ControladorVolverAPantallaAnterior;
import edu.fiuba.algo3.controlador.ControladorCambioDePantallas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VistaPantallaAyuda extends VBox {
    private final ControladorCambioDePantallas controladorCambioPantallas;
    private boolean estaJugando;

    public VistaPantallaAyuda(ControladorCambioDePantallas controladorCambioPantallas, boolean estaJugando) {
        this.controladorCambioPantallas = controladorCambioPantallas;
        this.estaJugando = estaJugando;
        this.inicializarVista();
    }

    private void inicializarVista() {
        this.getStyleClass().add("vista-pantalla-centrada");

        for (Seccion seccion : this.getSecciones()) {
            this.getChildren().add(seccion);
        }
        this.agregarBotonConControlador("Volver", new ControladorVolverAPantallaAnterior(this.controladorCambioPantallas, this.estaJugando));
    }

    private List<Seccion> getSecciones() {
        Gson gson = new Gson();
        List<Seccion> salida = new ArrayList<Seccion>();
        try (FileReader reader = new FileReader("src/main/resources/edu/fiuba/algo3/textos.json"))
        {
            //Read JSON file
            JsonObject textos = JsonParser.parseReader(reader).getAsJsonObject();
            JsonObject ayuda = textos.getAsJsonObject("ayuda");
            JsonArray secciones = ayuda.getAsJsonArray("secciones");

            for (JsonElement seccion : secciones) {
                JsonObject obj = (JsonObject) seccion;
                String[] lineas = gson.fromJson(
                    obj.getAsJsonArray("cuerpo"),
                    String[].class
                );
                System.out.println(lineas);
                salida.add(new Seccion(obj.get("titulo").getAsString(), String.join("\n", lineas)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salida;
    }

    private void agregarBotonConControlador(String contenido, EventHandler<ActionEvent> controlador) {
        Button boton = new Button(contenido);
        boton.setOnAction(controlador);
        this.getChildren().add(boton);
    }
}
