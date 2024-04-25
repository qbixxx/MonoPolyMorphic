package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.juego.Juego;

public class ComportamientoIrACarcel implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        jugador.setMensaje("👮️ Caiste en la carcel por saltar el molinete 🚔");
        int posicionAnterior = jugador.getPosicionActual();
        jugador.setPosicionActual(juego.getTablero().getPosicionCarcel());
        juego.encarcelarJugador(jugador, posicionAnterior);
        juego.siguienteTurno();
    }

    public String ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {
        return"";
    }
}
