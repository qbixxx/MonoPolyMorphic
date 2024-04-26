package example.vista.casillasView;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.example.model.casilla.Casilla;
import org.example.model.jugador.Jugador;
import org.example.vista.JugadorView;

public abstract class CasillaView extends StackPane {

    protected Casilla casilla;
    protected StackPane stackPane;

    private HBox jugadoresView;
    protected Rectangle colorView;

    protected Rectangle layout;

    public CasillaView(String text, Casilla casilla) {
        this.casilla = casilla;
        this.layout = new Rectangle(150, 130);
        this.layout.setStroke(Color.BLACK);
        this.layout.setFill(Color.WHITE);
        Text texto = new Text(text);
        this.stackPane = new StackPane();
        stackPane.getChildren().addAll(layout, texto);
        StackPane.setAlignment(texto, Pos.TOP_CENTER);
        getChildren().add(stackPane);
        this.jugadoresView = new HBox();
        this.stackPane.getChildren().add(this.jugadoresView);
        this.colorView = new Rectangle(150, 20); // Ancho y alto de la barra
        this.colorView.setFill(casilla.getDataCasilla().color);
        StackPane.setAlignment(this.colorView, Pos.BOTTOM_CENTER);
        this.stackPane.getChildren().add(this.colorView);

    }

    public void insertarJugador(JugadorView jugadorView) {
        StackPane.setAlignment(jugadorView, Pos.BOTTOM_CENTER);
        this.jugadoresView.getChildren().add(jugadorView);
    }
    public abstract void update(Jugador jugador);

    public void removerJugador(JugadorView jugadorView) {
        this.jugadoresView.getChildren().remove(jugadorView);
    }
}
