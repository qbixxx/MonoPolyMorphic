package org.tp1.model;

public class ComportamientoTransporte implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroTransporte casilleroTransporte = (CasilleroTransporte) casillero;
        if (casilleroTransporte.getDueno() != null) {
            casilleroTransporte.getDueno().recibirDinero(jugador, casilleroTransporte.getTarifa());
        }
    }
}
