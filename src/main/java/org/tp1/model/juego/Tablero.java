package org.tp1.model.juego;

import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.TipoCasillero;

public class Tablero {

    private final Casillero[] tablero;
    private int posicionCarcel;

    public Tablero(Casillero[] tablero) {
        this.tablero = tablero;
        this.posicionCarcel = obtenerPosicionCarcel();
    }

    private int obtenerPosicionCarcel() {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i].getTipoCasillero().equals(TipoCasillero.CARCEL)) {
                return i;
            }
        }
        throw new RuntimeException("No hay carcel en este tablero");
    }

    public Casillero[] getCasilleros() {
        return tablero;
    }

    public Casillero getCasillero(int indice) {
        return tablero[indice];
    }

    public int getPosicionCarcel() {
        return posicionCarcel;
    }

    private void setPosicionCarcel(int carcel) {
        this.posicionCarcel = carcel;
    }
}
