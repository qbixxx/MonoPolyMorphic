package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.juego.Juego;

public class ComportamientoIrACarcel implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        jugador.setearMensaje("👮️ Caiste en la carcel por saltar el molinete 🚔");
        int posicionAnterior = jugador.obtenerPosicionActual();
        jugador.setearPosicionActual(juego.getTablero().obtenerPosicionCarcel());
        juego.encarcelarJugador(jugador, posicionAnterior);
        juego.siguienteTurno();
    }

    public void ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {

    }
}
