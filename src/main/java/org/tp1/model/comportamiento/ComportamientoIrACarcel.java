package org.tp1.model.comportamiento;

import org.tp1.model.EstadoJugador;
import org.tp1.model.Juego;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;

public class ComportamientoIrACarcel implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        int posicionAnterior = jugador.getPosicionActual();
        jugador.setPosicionActual(juego.getTablero().getPosicionCarcel());
        jugador.setEstadoJugador(EstadoJugador.ENCARCELADO);
        juego.encarcelarJugador(jugador, posicionAnterior);
    }
}
