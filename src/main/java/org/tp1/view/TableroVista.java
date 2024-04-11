package org.tp1.view;

import org.tp1.model.Tablero;
import org.tp1.model.casilleros.Casillero;

public class TableroVista {

    private final Tablero tablero;

    public TableroVista(Tablero tablero) {
        this.tablero = tablero;
    }

    public void mostrarTablero() {
        for (Casillero casillero : tablero.getCasilleros()) {
            System.out.println(casillero.getNombre());
        }
    }

    public void mostrarOpciones(Casillero casillero) {
        casillero.mostrarOpcionesCasillero();
    }
}
