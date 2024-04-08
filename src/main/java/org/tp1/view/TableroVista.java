package org.tp1.view;

import org.tp1.model.Casillero;
import org.tp1.model.Tablero;

public class TableroVista {

    private Tablero tablero;

    public TableroVista(Tablero tablero) {
        this.tablero = tablero;
    }

    public void mostrarTablero() {
        for (Casillero casillero : tablero.getCasilleros()) { // horrible
            CasilleroVista casilleroVista = new CasilleroVista(casillero);
            casilleroVista.mostrarCasillero();
        }
    }
}
