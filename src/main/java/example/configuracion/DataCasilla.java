package example.configuracion;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class DataCasilla {

    public String texto;
    public Color color;
    public Image image;

    public DataCasilla(String texto, Color color, Image image) {
        this.texto = texto;
        this.color = color;
        this.image = image;
    }
}
