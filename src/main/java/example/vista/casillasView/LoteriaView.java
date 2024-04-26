package example.vista.casillasView;

import org.example.model.casilla.Casilla;
import org.example.model.jugador.Jugador;

public class LoteriaView extends CasillaView {


    public LoteriaView(Casilla casilla) {
        super("Loteria", casilla);
    }
    @Override
    public void update(Jugador jugador) {
        //super.updateJugador(jugador);
    }
}

