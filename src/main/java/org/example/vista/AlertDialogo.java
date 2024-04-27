package org.example.vista;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertDialogo {

    public AlertDialogo(String titulo, String text) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(text);
        ButtonType botonAceptar = new ButtonType("Aceptar");
        alert.getButtonTypes().setAll(botonAceptar);
        alert.showAndWait();
    }
}
