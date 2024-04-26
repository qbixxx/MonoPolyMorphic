package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroLoteria;
import org.tp1.model.juego.Juego;

public class ComportamientoLoteria implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroLoteria casilleroLoteria = (CasilleroLoteria) casillero;
        jugador.setearMensaje("💸 Ganaste la Lotería! El banco te depositó $"+casilleroLoteria.obtenerValorPozo());
        juego.cobro(jugador, casilleroLoteria.obtenerValorPozo());
    }

    public void ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {

    }
}
