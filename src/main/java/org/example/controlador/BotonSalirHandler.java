package org.example.controlador;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSalirHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Platform.exit();
    }
}
