package org.tp1.model.comportamiento;

import org.tp1.model.Juego;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroMulta;

public class ComportamientoMulta implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroMulta casilleroMulta = (CasilleroMulta) casillero;
        juego.cobro(jugador, -casilleroMulta.getValorMulta());
    }
}
