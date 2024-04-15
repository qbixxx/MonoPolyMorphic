package org.tp1.model;

public class ComportamientoIrACarcel implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        int posicionAnterior = jugador.getPosicionActual();
        jugador.setPosicionActual(juego.getTablero().getPosicionCarcel());
        jugador.setEstadoJugador(EstadoJugador.ENCARCELADO);
        juego.moverJugador(jugador, posicionAnterior);
    }
}
