package org.tp1.model;

public class Tablero {

    Casillero[] tablero;

    public Tablero(Casillero[] tablero) {
        this.tablero = tablero;
    }

    public Casillero[] getCasilleros() {
        return tablero;
    }
}
