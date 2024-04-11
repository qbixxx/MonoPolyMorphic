package org.tp1.view;

import org.tp1.model.Casillero;
import org.tp1.model.Tablero;

public class TableroVista {

    private final Tablero tablero;

    public TableroVista(Tablero tablero) {
        this.tablero = tablero;
    }

    public void mostrarTablero() {
        for (Casillero casillero : tablero.getCasilleros()) {
            CasilleroVista casilleroVista = new CasilleroVista(casillero);
            casilleroVista.mostrarCasillero();
        }
    }

    public void mostrarOpciones(Casillero casillero) {
        casillero.mostrarOpcionesCasillero();
    }
}
