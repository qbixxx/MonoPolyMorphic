package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroLoteria;
import org.tp1.model.juego.Juego;

public class ComportamientoLoteria implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroLoteria casilleroLoteria = (CasilleroLoteria) casillero;
        juego.cobro(jugador, casilleroLoteria.getValorPozo());
    }
}
