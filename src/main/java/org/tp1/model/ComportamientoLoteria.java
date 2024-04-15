package org.tp1.model;

public class ComportamientoLoteria implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroLoteria casilleroLoteria = (CasilleroLoteria) casillero;
        juego.cobro(jugador, casilleroLoteria.getValorPozo());
    }
}
