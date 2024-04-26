package org.example.model.casilla;

import org.example.configuracion.DataCasilla;
import org.example.model.Logger;
import org.example.model.Posicion;
import org.example.model.Tablero;
import org.example.model.jugador.Jugador;
import org.example.model.use_case.OpcionableLibre;

public class Loteria extends Casilla{

    private double monto = 100;

    public Loteria(Posicion p, DataCasilla dataCasilla) {
        this.posicion = p;
        this.dataCasilla = dataCasilla;
    }

    @Override
    public void interactuarCon(Jugador jugador, Tablero tablero) {
        jugador.agregarOpcionable(new OpcionableLibre(jugador));
        Logger.getInstance().info("Loteria, recibe " + monto);
        jugador.recibirPago(this.monto);
    }
}
