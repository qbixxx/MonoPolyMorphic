package org.tp1.model.comportamiento;

import org.tp1.model.Juego;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;

public interface ComportamientoCasilla {
    void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego);
}