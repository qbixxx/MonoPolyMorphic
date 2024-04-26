package example;

import example.model.Juego;
import example.vista.InicioView;
import example.vista.View;
import javafx.application.Application;
import javafx.stage.Stage;

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
        stage.setResizable(false);
        View.setDimensions(1500, 1000);
    }

    public static void main(String[] args) {
        launch();
    }
}