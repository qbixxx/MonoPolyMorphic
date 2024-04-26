package example.model.casilla;

import org.example.configuracion.DataCasilla;
import org.example.model.Posicion;
import org.example.model.Tablero;
import org.example.model.jugador.Jugador;

public abstract class Casilla {


    protected Posicion posicion;

    protected DataCasilla dataCasilla;
    public abstract void interactuarCon(Jugador jugador, Tablero tablero);

    public Posicion getPosicion() {
        return this.posicion;
    }

    public DataCasilla getDataCasilla() {
        return this.dataCasilla;
    }
}
