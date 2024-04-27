package org.example.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.example.model.Juego;
import org.example.vista.SeleccionView;

public class BotonIniciarSeleccionHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final Juego JUEGO;


    public BotonIniciarSeleccionHandler(Stage stage, Juego juego) {
        this.STAGE = stage;
        this.JUEGO = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SeleccionView seleccion = new SeleccionView(STAGE, JUEGO);
        STAGE.setScene(seleccion.getScene());
    }
}