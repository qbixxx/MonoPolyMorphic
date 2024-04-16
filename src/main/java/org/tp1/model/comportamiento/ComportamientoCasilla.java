package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.juego.Juego;

public interface ComportamientoCasilla {
    void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego);
}
