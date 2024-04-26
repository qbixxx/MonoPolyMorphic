package example.vista;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import org.example.model.jugador.Jugador;

public class JugadorView extends Circle {

    private Jugador jugador;
    private Color color;

    public JugadorView(Jugador jugador, Color color) {
        super(18.5, color);
        this.color = color;
        this.jugador = jugador;
        setStroke(Color.BLACK);
        setStrokeWidth(2.5);
        setStrokeType(StrokeType.INSIDE);
    }

    public boolean es(Jugador jugador) {
        return this.jugador.equals(jugador);
    }


    public Jugador getJugador() {
        return this.jugador;
    }

    public Color getColor() {
        return this.color;
    }
}