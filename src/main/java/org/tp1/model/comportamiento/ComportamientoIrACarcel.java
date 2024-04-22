package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.juego.Juego;

public class ComportamientoIrACarcel implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        int posicionAnterior = jugador.getPosicionActual();
        jugador.setPosicionActual(juego.getTablero().getPosicionCarcel());
        juego.encarcelarJugador(jugador, posicionAnterior);
    }
}
