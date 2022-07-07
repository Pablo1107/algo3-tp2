package edu.fiuba.algo3.controlador;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.ToNumberPolicy;

public class ControladorHistorialPartidas {
    public final String RUTA_RANKING = "src/main/resources/edu/fiuba/algo3/partidas.json";

    public void guardarRegistroPartida(HashMap<String, Long> ranking) {
        Gson gson = new Gson();

        try {
            File archivo = new File(RUTA_RANKING);
            if (!archivo.exists()) archivo.createNewFile();
            FileWriter writer = new FileWriter(archivo);
            gson.toJson(ranking, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Long> getHistorialPartidas() {
        Gson gson = new GsonBuilder()
                .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                .create();

        try {
            File archivo = new File(RUTA_RANKING);
            if (!archivo.exists()) return new HashMap<String, Long>();
            FileReader reader = new FileReader(archivo);
            JsonObject jsonArray = JsonParser.parseReader(reader).getAsJsonObject();
            return gson.fromJson(jsonArray, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
