package example.vista.casillasView;

import org.example.model.casilla.Casilla;
import org.example.model.jugador.Jugador;

public class DePasoView extends CasillaView {


    public DePasoView(Casilla casilla) {
        super("DePaso", casilla);
    }

    @Override
    public void update(Jugador jugador) {

    }
}
