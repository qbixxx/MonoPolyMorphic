package org.tp1.model;

public class ComportamientoPropiedad implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
        if (casilleroPropiedad.getDueno() != null) {
            casilleroPropiedad.getDueno().recibirDinero(jugador, casilleroPropiedad.getRenta());
        }
    }
}
