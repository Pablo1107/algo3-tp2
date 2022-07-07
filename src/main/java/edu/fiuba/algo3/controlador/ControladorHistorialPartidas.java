package edu.fiuba.algo3.controlador;

import com.google.gson.*;

import java.io.*;
import java.util.HashMap;

public class ControladorHistorialPartidas {
    public final String RUTA_RANKING = "src/main/resources/edu/fiuba/algo3/partidas.json";

    public void guardarRanking(HashMap<String, Long> ranking) {
        Gson gson = new Gson();

        try {
            File archivo = new File(RUTA_RANKING);
            if (!archivo.exists()) archivo.createNewFile();
            FileWriter writer = new FileWriter(archivo);
            gson.toJson(ranking, writer);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonIOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Long> cargarRanking() {
        Gson gson = new GsonBuilder()
                .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                .create();

        try {
            File archivo = new File(RUTA_RANKING);
            if (!archivo.exists()) return new HashMap<String, Long>();
            FileReader reader = new FileReader(archivo);
            JsonObject jsonArray = JsonParser.parseReader(reader).getAsJsonObject();
            return gson.fromJson(jsonArray, HashMap.class);
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
