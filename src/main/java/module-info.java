module edu.fiuba.algo3 {
    requires javafx.controls;
    requires java.desktop;
    requires json.simple;
    requires com.google.gson;
    opens edu.fiuba.algo3.vista.partidas to com.google.gson;
    requires javafx.media;
    exports edu.fiuba.algo3;
}
