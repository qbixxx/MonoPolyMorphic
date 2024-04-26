package org.example.model.casilla;

import org.example.configuracion.DataCasilla;
import org.example.model.Posicion;
import org.example.model.Tablero;
import org.example.model.jugador.Jugador;
import org.example.model.use_case.OpcionableLibre;

public class LLegadaPartida extends Casilla {

    public LLegadaPartida(Posicion posicion, DataCasilla dataCasilla) {
        this.posicion = posicion;
        this.dataCasilla = dataCasilla;
    }
    @Override
    public void interactuarCon(Jugador jugador, Tablero tablero) {
        jugador.agregarOpcionable(new OpcionableLibre(jugador));
    }

}
