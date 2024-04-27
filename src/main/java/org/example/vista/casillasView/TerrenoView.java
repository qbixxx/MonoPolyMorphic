package org.example.vista.casillasView;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import org.example.model.Logger;
import org.example.model.casilla.Terreno;
import org.example.model.jugador.Jugador;
import org.example.model.propiedades.construibles.Casa;
import org.example.model.propiedades.construibles.Edificio;
import org.example.model.use_case.*;
import org.example.vista.AlertDialogo;
import org.example.vista.JugadorView;
import org.example.vista.View;

import java.util.Objects;

public class TerrenoView extends CasillaView {
    private Button botonElegir = new Button("Elegir");
    private Terreno terreno;
    private HBox edificiosView;

    public TerrenoView(Terreno casilla) {
        super(casilla.getGrupo(), casilla);
        this.terreno = casilla;
        this.edificiosView = new HBox();
        HBox.setHgrow(edificiosView, Priority.ALWAYS);
        edificiosView.setAlignment(Pos.CENTER);
        this.stackPane.getChildren().add(this.edificiosView);
    }
    public void updateConstrucciones(Jugador jugador) {
        this.updateConstruccionesTerrenos();
        if (!this.terreno.lePerteneceA(jugador))
            this.stackPane.getChildren().remove(this.botonElegir);
    }

    public void updateConstruccionesTerrenos() {
        this.edificiosView.getChildren().clear();
        Logger.getInstance().info(String.valueOf(this.terreno.getEdificios().size()));
        for (Edificio edificio : this.terreno.getEdificios()) {
            Image imagen;
            if (edificio instanceof Casa) {
                imagen = new Image(Objects.requireNonNull(View.class.getResource("/casa_monopoly.jpg")).toExternalForm());
            } else {
                imagen = new Image(Objects.requireNonNull(View.class.getResource("/hotel_monopoly.jpg")).toExternalForm());
            }
            ImageView imageView = new ImageView(imagen);
            imageView.setFitWidth(edificio instanceof Casa ? 35 : 50);
            imageView.setFitHeight(edificio instanceof Casa ? 35 : 50);
            this.edificiosView.getChildren().add(imageView);
        }
    }

    public boolean mostrarBotonesElegibles(Jugador jugador, String accion) {
        boolean esta = this.terreno.lePerteneceA(jugador);
        if (esta) {
            StackPane.setAlignment(this.botonElegir, Pos.BOTTOM_CENTER);
            this.stackPane.getChildren().add(this.botonElegir);
            this.botonElegir.setOnAction(e -> {
                Opcionable opcionable = accion.equals("Construir Casa") ? new ConstruirCasaUseCase(jugador, terreno) :
                        accion.equals("Construir Hotel") ? new ConstruirHotelUseCase(jugador, terreno):
                        accion.equals("Hipotecar") ? new HipotecarUseCase(jugador, terreno) :
                        accion.equals("DesHipotecar") ? new DesHipotecarUseCase(jugador, terreno) :
                        accion.equals("Vender Casa") ? new VenderCasaUseCase(jugador, terreno):
                        accion.equals("Vender Hotel") ? new VenderHotelUseCase(jugador, terreno) :
                        accion.equals("Vender Propiedad") ? new VenderPropiedadUseCase(jugador, terreno) : null;
                assert opcionable != null;
                try {
                    opcionable.ejecutar();
                    updateConstrucciones(jugador);
                    if (opcionable instanceof VenderPropiedadUseCase)
                        this.layout.setFill(Color.WHITE);
                } catch (Exception ex) {
                    new AlertDialogo("Accion invalida", ex.getMessage());
                }
            });
        }
        return esta;
    }

    public void actualizarVistaPropiedad(JugadorView jugador) {
        if (this.terreno.lePerteneceA(jugador.getJugador())) {
            this.layout.setFill(jugador.getColor());
        }
    }

    public void quitarBotonCompra() {
        this.stackPane.getChildren().remove(this.botonElegir);
    }

    @Override
    public void update(Jugador jugador) {
        //super.updateJugador(jugador);
        //this.updateConstrucciones(jugador);
    }
}