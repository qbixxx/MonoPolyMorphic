package org.example.vista.casillasView;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import org.example.model.casilla.Transporte;
import org.example.model.jugador.Jugador;
import org.example.model.use_case.*;
import org.example.vista.AlertDialogo;
import org.example.vista.JugadorView;

public class TransporteView extends CasillaView{

    private Transporte transporte;
    private Button botonElegir = new Button("Elegir");

    public TransporteView(Transporte casilla) {
        super(casilla.getGrupo(), casilla);
        this.transporte = casilla;
    }

    public boolean mostrarBotonesElegibles(Jugador jugador, String accion) {
        boolean esta = this.transporte.lePerteneceA(jugador);
        if (esta) {
            StackPane.setAlignment(this.botonElegir, Pos.BOTTOM_CENTER);
            this.stackPane.getChildren().add(this.botonElegir);
            this.botonElegir.setOnAction(e -> {
                Opcionable opcionable = accion.equals("Vender Propiedad") ? new VenderPropiedadUseCase(jugador, this.transporte) : null;
                if(opcionable != null) {
                    opcionable.ejecutar();
                    this.quitarBotonesElegibles(jugador);
                    this.layout.setFill(Color.WHITE);
                }
                else
                    new AlertDialogo("Error", "Accion invalida sobre un transporte");
            });
        }
        return esta;
    }

    public void quitarBotonesElegibles(Jugador jugador) {
        if (!this.transporte.lePerteneceA(jugador))
            this.stackPane.getChildren().remove(this.botonElegir);
    }

    public void actualizarVistaPropiedad(JugadorView jugador) {
        if (this.transporte.lePerteneceA(jugador.getJugador())) {
            this.layout.setFill(jugador.getColor());
        }
    }
    @Override
    public void update(Jugador jugador) {

    }

    public void quitarBotonCompra() {
        this.stackPane.getChildren().remove(this.botonElegir);
    }
}
