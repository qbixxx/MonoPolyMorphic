package org.tp1.model;

import org.tp1.model.casilleros.Casillero;

public class Tablero {

    Casillero[] tablero;

    public Tablero(Casillero[] tablero) {
        this.tablero = tablero;
    }

    public Casillero[] getCasilleros() {
        return tablero;
    }
}
