package example.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.example.model.Juego;
import org.example.vista.TableroView;

public class ButtonTerminaTurno implements EventHandler<ActionEvent> {

    private final Stage STAGE;
    private final Juego juego;
    private final TableroView tableroView;


    public ButtonTerminaTurno(Stage stage, Juego juego, TableroView tableroView) {
        this.STAGE = stage;
        this.juego = juego;
        this.tableroView = tableroView;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.tableroView.quitarOpcionable();
        //this.tableroView.buttonTirarDados.setDisable(false);
        this.juego.cambiarTurno();
    }
}
