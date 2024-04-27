package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.model.Juego;
import org.example.vista.InicioView;
import org.example.vista.View;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        configurarVentana(primaryStage);
        Juego juego = new Juego();
        InicioView inicio = new InicioView(primaryStage, juego);
        primaryStage.setScene(inicio.getScene());
        primaryStage.show();
    }

    private void configurarVentana(Stage stage) {
        stage.setTitle("Monopoly");
        View.setDimensions(1500, 1000);
    }

    public static void main(String[] args) {
        launch();
    }
}