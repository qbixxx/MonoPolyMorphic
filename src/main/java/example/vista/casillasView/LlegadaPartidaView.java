package example.vista.casillasView;

import org.example.model.casilla.Casilla;
import org.example.model.jugador.Jugador;

public class LlegadaPartidaView extends CasillaView {

    public LlegadaPartidaView(Casilla c) {
        super("Llegada\nPartida", c);
    }
    @Override
    public void update(Jugador jugador) {
        //super.updateJugador(jugador);
    }
}
