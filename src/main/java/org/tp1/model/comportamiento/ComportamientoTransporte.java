package org.tp1.model.comportamiento;

import org.tp1.model.Juego;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroTransporte;

public class ComportamientoTransporte implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroTransporte casilleroTransporte = (CasilleroTransporte) casillero;
        if (casilleroTransporte.getDueno() != null) {
            casilleroTransporte.getDueno().recibirDinero(jugador, casilleroTransporte.getTarifa());
        }
    }
}
