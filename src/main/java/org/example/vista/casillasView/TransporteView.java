package org.example.vista.casillasView;

import javafx.scene.control.Button;
import org.example.model.casilla.Transporte;
import org.example.model.jugador.Jugador;

public class TransporteView extends CasillaView{

    private Transporte casilla;
    private Button botonElegir = new Button("Elegir");

    public TransporteView(Transporte casilla) {
        super(casilla.getGrupo(), casilla);
        this.casilla = casilla;
    }
    @Override
    public void update(Jugador jugador) {

    }
}
