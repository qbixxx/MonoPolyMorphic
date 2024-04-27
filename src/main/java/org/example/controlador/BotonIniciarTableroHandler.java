package org.example.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.model.Dado;
import org.example.model.Juego;
import org.example.model.jugador.Jugador;
import org.example.model.jugador.Saldo;
import org.example.vista.TableroView;

import java.util.ArrayList;
import java.util.List;

public class BotonIniciarTableroHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final Juego juego;
    private final ArrayList<TextField> INPUTS;

    public BotonIniciarTableroHandler(ArrayList<TextField> inputs, Stage stage, Juego juego) {
        this.STAGE = stage;
        this.INPUTS = inputs;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        List<Jugador> jugadores = new ArrayList<>();
        for (TextField input : INPUTS) {
            String nombreGladiador = input.getText();
            jugadores.add(new Jugador(new Saldo(2000), new Dado(), nombreGladiador));
        }
        this.juego.agregarJugadores(jugadores);
        TableroView tablero = new TableroView(juego, STAGE);
        STAGE.setScene(tablero.getScene());
    }
}