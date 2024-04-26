package org.example.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.controlador.BotonIniciarTableroHandler;
import org.example.model.Juego;

import java.util.ArrayList;

public class JugadoresView  extends View {

    private static final int TEXTFIELD_W = 150;
    private final Stage STAGE;
    private final Scene SCENE;
    private final VBox LAYOUT;
    private final Juego JUEGO;
    private final ArrayList<TextField> INPUTS = new ArrayList<>();

    public JugadoresView(Stage stage, int cantidadJugdores, Juego juego) {
        this.STAGE = stage;
        this.LAYOUT = new VBox(SPACING);
        LAYOUT.setAlignment(Pos.CENTER);
        this.JUEGO = juego;

        configurarTitulo();
        configurarInputs(cantidadJugdores);
        configurarBotonComenzar();
        configurarBackground(LAYOUT);

        SCENE = new Scene(LAYOUT, WIDTH, HEIGHT);
    }

    private void configurarTitulo() {
        Label titulo = new Label("Elige a los jugadores");
        configurarTitulo(titulo, TXT_FONT, TITULO_FS);
        LAYOUT.getChildren().add(titulo);
    }

    private void configurarInputs(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            Label jugador = new Label("Jugador " + (i + 1));
            configurarTitulo(jugador, TXT_FONT, TXT_FS);

            TextField nombre = new TextField();
            configurarTextField(nombre);
            INPUTS.add(nombre);

            HBox inputContainer = new HBox(SPACING);
            inputContainer.setAlignment(Pos.CENTER);
            inputContainer.getChildren().addAll(jugador, nombre);

            LAYOUT.getChildren().add(inputContainer);
        }
    }

    private void configurarTextField(TextField textField) {
        textField.setFont(Font.loadFont(getClass().getResourceAsStream(TXT_FONT), BTN_FS));
        textField.setStyle("-fx-background-radius: 5; -fx-font-weight: bold; -fx-alignment: center");
        textField.setPromptText("Nombre");
        textField.setMaxWidth(TEXTFIELD_W);
        textField.setMaxHeight(BTN_HEIGHT);
    }

    private void configurarBotonComenzar() {
        Button comenzar = new Button("Comenzar");
        configurarBoton(comenzar);
        comenzar.setOnAction(new BotonIniciarTableroHandler(INPUTS, STAGE, JUEGO));

        LAYOUT.getChildren().add(comenzar);
    }

    public Scene getScene() {
        return SCENE;
    }
}
