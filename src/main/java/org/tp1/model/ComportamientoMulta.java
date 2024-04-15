package org.tp1.model;

public class ComportamientoMulta implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroMulta casilleroMulta = (CasilleroMulta) casillero;
        juego.cobro(jugador, -casilleroMulta.getValorMulta());
    }
}
