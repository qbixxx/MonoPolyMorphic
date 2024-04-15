package org.tp1.model.comportamiento;

import org.tp1.model.Juego;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroLoteria;

public class ComportamientoLoteria implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroLoteria casilleroLoteria = (CasilleroLoteria) casillero;
        juego.cobro(jugador, casilleroLoteria.getValorPozo());
    }
}
