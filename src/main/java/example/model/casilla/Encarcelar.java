package example.model.casilla;

import org.example.configuracion.DataCasilla;
import org.example.model.Logger;
import org.example.model.Posicion;
import org.example.model.Tablero;
import org.example.model.jugador.Jugador;
import org.example.model.use_case.EncarcelarUseCase;

public class Encarcelar extends Casilla {

    public Encarcelar(Posicion posicion, DataCasilla dataCasilla) {
        this.posicion = posicion;
        this.dataCasilla = dataCasilla;
    }
    @Override
    public void interactuarCon(Jugador jugador, Tablero tablero) {
        Logger.getInstance().info("Tenes que ir a la carcel!!!!!");
        jugador.agregarOpcionable(new EncarcelarUseCase(jugador, tablero));
    }
}
