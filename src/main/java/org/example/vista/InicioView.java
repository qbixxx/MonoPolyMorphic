package org.example.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controlador.BotonIniciarSeleccionHandler;
import org.example.controlador.BotonSalirHandler;
import org.example.model.Juego;

public class InicioView extends View {
    private final Stage STAGE;
    private final Scene SCENE;
    private final VBox LAYOUT;
    private final Juego JUEGO;

    public InicioView(Stage stage, Juego juego) {
        this.STAGE = stage;
        this.LAYOUT = new VBox();
        LAYOUT.setAlignment(Pos.CENTER);
        this.JUEGO = juego;


        configurarTituloPrincipal();
        configurarBotones();
        configurarBackground(LAYOUT);


        SCENE = new Scene(LAYOUT, WIDTH, HEIGHT);
    }

    private void configurarTituloPrincipal() {
        Label titleText = new Label("Monopoly");
        configurarTitulo(titleText, TITULO_PRINCIPAL_FONT, TITULO_PRINCIPAL_FS);
        LAYOUT.getChildren().add(titleText);
    }

    private void configurarBotones() {

        Button iniciar = new Button("Iniciar");
        configurarBoton(iniciar);
        iniciar.setOnAction(new BotonIniciarSeleccionHandler(STAGE, JUEGO));

        Button salida = new Button("Salir");
        configurarBoton(salida);
        salida.setOnAction(new BotonSalirHandler());

        LAYOUT.getChildren().addAll(iniciar, salida);
    }

    public Scene getScene() {
        return SCENE;
    }
}
