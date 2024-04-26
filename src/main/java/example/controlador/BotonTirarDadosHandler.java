package example.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.example.model.Juego;
import org.example.model.Posicion;
import org.example.model.jugador.Jugador;
import org.example.vista.TableroView;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final Juego juego;
    private final TableroView tableroView;

    public BotonTirarDadosHandler(Stage stage, Juego juego, TableroView tableroView) {
        this.STAGE = stage;
        this.juego = juego;
        this.tableroView = tableroView;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorEnTurno = this.juego.getJugadorEnTurno();
        Posicion vieajPosicion = jugadorEnTurno.getPosicion();
        this.juego.ejecutarTurno();
        this.tableroView.mostrarOpcionable(this.juego.getJugadorEnTurno());
        tableroView.actualizarVista(vieajPosicion, jugadorEnTurno);
        this.tableroView.insertarTexto();
    }
}