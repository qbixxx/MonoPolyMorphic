package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroLoteria;
import org.tp1.model.juego.Juego;

public class ComportamientoLoteria implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroLoteria casilleroLoteria = (CasilleroLoteria) casillero;
        jugador.setMensaje("💸 Ganaste la Lotería! El banco te depositó $"+casilleroLoteria.getValorPozo());
        juego.cobro(jugador, casilleroLoteria.getValorPozo());
    }

    public String ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {
        return "";
    }
}
