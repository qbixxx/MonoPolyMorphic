package example.vista.casillasView;

import org.example.model.casilla.Casilla;
import org.example.model.jugador.Jugador;

public class EnCarcelarView extends CasillaView {


    public EnCarcelarView(Casilla c) {
        super("Encarcelar", c);
    }
    @Override
    public void update(Jugador jugador) {
        //super.updateJugador(jugador);
    }
}
