package org.example.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.controlador.BotonTirarDadosHandler;
import org.example.controlador.ButtonTerminaTurno;
import org.example.controlador.Controller;
import org.example.model.Juego;
import org.example.model.Logger;
import org.example.model.Posicion;
import org.example.model.Tablero;
import org.example.model.casilla.*;
import org.example.model.jugador.Jugador;
import org.example.vista.casillasView.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class TableroView extends View  {

    private Tablero tablero;
    private Scene scene;

    private ScrollPane scrollPane;
    private Stage stage;

    private Juego juego;
    private GridPane grillaTablero = new GridPane();
    private CasillaView[][] casillasView;

    private List<JugadorView> jugadorViews;
    private List<Color> colores;

    public Button opcionableExtra = new Button("Tersddawdar");
    private int rows = 26;
    private int cols = 26;
    private HBox hBox;

    private TextArea textArea;


    public Button buttonTerminar = new Button("Terminar");

    private HBox pantalla = new HBox();

    private VBox columnaOpciones = new VBox();

    private VBox opcionables;
    private Button buttonTirarDados;

    public Button buttonBack = new Button("Volver");

    public TableroView(Juego juego, Stage stage) {
        this.juego = juego;
        this.jugadorViews = new ArrayList<>();
        this.casillasView = new CasillaView[rows][cols];
        this.buttonTirarDados = new Button("Tirar dados");
        this.tablero = juego.getTablero();
        this.colores = new ArrayList<>(List.of(
                Color.rgb(255, 255, 102),   // Amarillo claro
                Color.rgb(255, 154, 200),   // Naranja claro
                Color.rgb(255, 192, 203),   // Rosa claro
                Color.rgb(245, 155, 120))
        );
        this.construir();
        this.stage = stage;
        this.pantalla.getChildren().add(this.grillaTablero);
        Pane espacioHorizontal = new Pane();
        espacioHorizontal.setPrefWidth(50);
        pantalla.getChildren().add(espacioHorizontal);
        this.pantalla.getChildren().add(this.columnaOpciones);
        this.buttonTirarDados.setAlignment(Pos.CENTER);
        this.buttonTirarDados.setPrefWidth(200);
        this.buttonTirarDados.setPrefHeight(50);
        this.buttonBack.setPrefWidth(200);
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background = new Background(backgroundFill);
        this.buttonTirarDados.setTextFill(Color.WHITE);
        this.buttonTirarDados.setBackground(background);
        this.scene = new Scene(this.pantalla, WIDTH, HEIGHT);
        this.buttonTirarDados.setOnAction(new BotonTirarDadosHandler(this.stage, juego, this));
        this.insertarTextoEnVBox();
        this.columnaOpciones.getChildren().add(this.buttonTirarDados);
        this.pantalla.setBackground(new Background(new BackgroundFill(Color.rgb(51, 51, 51), null, null)));
    }

    public void construir() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Casilla c = this.tablero.getCasillasEn(new Posicion(row, col));
                if (c != null) {
                    CasillaView casillaView = crearCasilla(c);
                    this.casillasView[row][col] = casillaView;
                    this.grillaTablero.add(casillaView, col, row);
                }
            }
        }
        List<Jugador> jugadores = this.tablero.getJugadores();
        Logger.getInstance().info(String.valueOf(jugadores.size()));
        IntStream.range(0, jugadores.size())
                .forEach(i -> {
                    Jugador jugador = jugadores.get(i);
                    Color color = this.colores.get(i);
                    JugadorView jugadorView = new JugadorView(jugador, color);
                    this.jugadorViews.add(jugadorView);
                    this.casillasView[0][0].insertarJugador(jugadorView);
                });
    }
    public void actualizarVista(Posicion vieajPosicion, Jugador jugador) {
        Optional<JugadorView> jugadorViewActual = this.jugadorViews.stream()
                .filter(jugadorView -> jugadorView.es(jugador))
                .findFirst();
        jugadorViewActual.ifPresent(jugadorView -> {

            this.casillasView[vieajPosicion.x][vieajPosicion.y].removerJugador(jugadorView);
            this.casillasView[jugador.getPosicion().x][jugador.getPosicion().y].insertarJugador(jugadorView);
        });
    }

    public void insertarTexto() {
        this.textArea.setText(this.textArea.getText() + "\n" + Logger.getInstance().mostrarInfo());
    }

    public void eliminarJugadorView(Jugador jugador) {
        Optional<JugadorView> jugadorViewActual = this.jugadorViews.stream()
                .filter(jugadorView -> jugadorView.es(jugador))
                .findFirst();
        jugadorViewActual.ifPresent(jugadorView -> {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (this.casillasView[row][col] != null && this.casillasView[row][col] instanceof TerrenoView)
                        ((TerrenoView) this.casillasView[row][col]).updateConstruccionesTerrenos();
                }
            }
            this.casillasView[jugador.getPosicion().x][jugador.getPosicion().y].removerJugador(jugadorView);
            this.jugadorViews.remove(jugadorView);
        });
    }

    public void mostrarCasillaElegible(Jugador jugador, String accion) {
        boolean esta = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (this.casillasView[row][col] != null && this.casillasView[row][col] instanceof TerrenoView)
                    if (((TerrenoView) this.casillasView[row][col]).mostrarBotonesElegibles(jugador, accion) && !esta)
                        esta = true;
            }
        }
        if (!esta)
            new AlertDialogo("Error", "No tiene propiedades disponibles");
    }

    private void mostrarOpcionableExtra(Jugador jugador) {
        String opcionableExtraText = jugador.getOpcionable().getOpcionableExtra();
        if (opcionableExtraText != null) {
            this.opcionableExtra = new Button(opcionableExtraText);
            this.opcionableExtra.setPrefHeight(50);
            this.opcionableExtra.setPrefWidth(200);
            BackgroundFill backgroundFill = new BackgroundFill(Color.BLUE, null, null);
            Background background = new Background(backgroundFill);
            this.opcionableExtra.setTextFill(Color.WHITE);
            this.opcionableExtra.setBackground(background);
            this.opcionables.getChildren().add(this.opcionableExtra);
            this.opcionableExtra.setOnAction(new Controller(this.juego, this));

            if (opcionableExtraText.equals("Pagar peaje") || opcionableExtraText.equals("Pagar multa") || opcionableExtraText.equals("Ir a la carcel"))
                this.buttonTerminar.setDisable(true);
        }
    }

    public void quitarOpcionableExtra() {
        this.opcionables.getChildren().remove(this.opcionableExtra);
    }

    public void actualizarCasillas(Jugador jugador) {
        Optional<JugadorView> jugadorViewActual = this.jugadorViews.stream()
                .filter(jugadorView -> jugadorView.es(jugador))
                .findFirst();
        jugadorViewActual.ifPresent(jugadorView -> {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (this.casillasView[row][col] != null && this.casillasView[row][col] instanceof TerrenoView) {
                        ((TerrenoView) this.casillasView[row][col]).actualizarVistaPropiedad(jugadorView);
                    }
                }
            }
        });
    }
    public void mostrarOpcionable(Jugador jugador) {
        this.opcionables = new VBox();
        this.buttonTirarDados.setDisable(true);
        List<String> opcionables = jugador.getOpcionable().getOpcionables();
        this.opcionables.setAlignment(Pos.CENTER);
        this.opcionables.setSpacing(15);
        for (String nombreOpcionable : opcionables) {
            Button boton = new Button(nombreOpcionable);
            boton.setPrefWidth(200);
            boton.setOnAction(e -> {
                this.quitarOpcionable();
                this.buttonTirarDados.setDisable(true);
                this.mostarAceptarCancelar(jugador);
                this.mostrarCasillaElegible(jugador, nombreOpcionable);
            });
            this.opcionables.getChildren().add(boton);
        }
        this.mostrarOpcionableExtra(jugador);
        if (!opcionables.contains("Pagar multa") || !opcionables.contains("Pagar peaje")) {
            this.buttonTerminar.setPrefWidth(200);
            this.buttonTerminar.setOnAction(new ButtonTerminaTurno(this.stage, this.juego, this));
            this.opcionables.getChildren().add(this.buttonTerminar);
        }

        this.columnaOpciones.getChildren().add(this.opcionables);
    }

    public void mostarAceptarCancelar(Jugador jugador) {
        this.opcionables = new VBox();
        this.opcionables.getChildren().add(this.buttonBack);
        this.columnaOpciones.getChildren().add(this.opcionables);
        this.buttonBack.setOnAction(e -> {
            this.quitarOpcionable();
            this.quitarBotonesCompra();
            this.mostrarOpcionable(jugador);
        });
    }
    private void quitarBotonesCompra() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.quitarBotonesElegibles(row, col);
            }
        }
    }

    private void quitarBotonesElegibles(int row, int col) {
        if (this.casillasView[row][col] != null && this.casillasView[row][col] instanceof TerrenoView)
            ((TerrenoView) this.casillasView[row][col]).quitarBotonCompra();
    }

    public void quitarOpcionable() {
        this.buttonTirarDados.setDisable(false);
        this.columnaOpciones.getChildren().remove(this.opcionables);
    }
    public CasillaView crearCasilla(Casilla c) {
        return switch (c) {
            case Terreno t -> new TerrenoView(t);
            case DePaso d -> new DePasoView(d);
            case Loteria l -> new LoteriaView(l);
            case Multa m -> new MultaView(m);
            case LLegadaPartida l -> new LlegadaPartidaView(l);
            case Transporte t -> new TransporteView(t);
            case Encarcelar e -> new EnCarcelarView(e);
            case Carcel ca -> new CarcelView(ca);
            default -> null; // implementar factory
        };
    }

    public void insertarTextoEnVBox() {
        this.textArea = new TextArea();
        textArea.setPrefWidth(200);
        textArea.setPrefHeight(300);
        textArea.setWrapText(true);
        this.textArea.setEditable(false);
        this.scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        this.columnaOpciones.getChildren().add(scrollPane);
    }

    public Scene getScene() {
        return this.scene;
    }
}
