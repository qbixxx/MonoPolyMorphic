package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.juego.Juego;

public class ComportamientoPropiedad implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
        if (casilleroPropiedad.getDueno() != null) {
            casilleroPropiedad.getDueno().recibirDinero(jugador, casilleroPropiedad.getRenta());
        }
    }
}
