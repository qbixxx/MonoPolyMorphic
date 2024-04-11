package org.tp1.model;

public class Juego {
    private final Tablero tablero;
    private final Jugador[] jugadores;
    private int posicionJugadorDeTurno;

    public Juego(Tablero tablero, Jugador[] jugadores) {
        this.tablero = tablero;
        this.jugadores = jugadores;
    }

    public Jugador jugadorEnTurnoActual() {
        return jugadores[posicionJugadorDeTurno];
    }

    public void siguienteTurno() {
        posicionJugadorDeTurno += 1;
        if (posicionJugadorDeTurno > jugadores.length - 1) {
            posicionJugadorDeTurno = 0;
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

}
