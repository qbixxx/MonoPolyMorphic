package org.example.vista.casillasView;

import javafx.scene.layout.StackPane;
import org.example.model.casilla.Casilla;
import org.example.model.jugador.Jugador;

public class MultaView extends CasillaView {
    private StackPane stackPane;

    public MultaView(Casilla c) {
        super("Multa", c);
    }

    @Override
    public void update(Jugador jugador) {
        //super.updateJugador(jugador);
    }
}
