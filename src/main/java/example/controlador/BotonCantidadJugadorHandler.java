package example.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.example.model.Juego;
import org.example.vista.JugadoresView;

public class BotonCantidadJugadorHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final int CANTIDAD_JUGADORES;
    private final Juego JUEGO;

    public BotonCantidadJugadorHandler(Stage stage, int cantidadJugadores, Juego juego) {
        this.STAGE = stage;
        this.CANTIDAD_JUGADORES = cantidadJugadores;
        this.JUEGO = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        JugadoresView jugadores = new JugadoresView(STAGE, CANTIDAD_JUGADORES, JUEGO);
        STAGE.setScene(jugadores.getScene());
    }
}