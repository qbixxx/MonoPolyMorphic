package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroMulta;
import org.tp1.model.juego.Juego;

public class ComportamientoMulta implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroMulta casilleroMulta = (CasilleroMulta) casillero;
        jugador.setMensaje("Te pescó la aduana traficando autopartes. Pagás una multa de $"+casilleroMulta.getValorMulta());
        juego.cobro(jugador, -casilleroMulta.getValorMulta());
    }
    public void ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {

    }
}
