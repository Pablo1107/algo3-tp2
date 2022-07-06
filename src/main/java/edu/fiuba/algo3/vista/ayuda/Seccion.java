package edu.fiuba.algo3.vista.ayuda;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.json.simple.JSONObject;

public class Seccion extends VBox {

    public Seccion(String titulo, String cuerpo) {
        this.getStyleClass().add("seccion");
        Text tituloText = new Text(titulo);
        tituloText.getStyleClass().add("seccion-titulo");

        Text cuerpoText = new Text(cuerpo);
        cuerpoText.getStyleClass().add("seccion-cuerpo");

        this.getChildren().add(tituloText);
        this.getChildren().add(cuerpoText);
    }

//    public Seccion(JSONObject obj) {
//        this(obj.get("titulo"), obj.get("cuerpo"));
//    }
}
