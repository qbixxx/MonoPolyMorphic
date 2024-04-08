package org.tp1.model;

public class Juego {
    private final Tablero tablero;
    private final Jugador[] jugadores;
    private final GestorDeTurno gestorDeTurno;

    public Juego(Tablero tablero, Jugador[] jugadores) {
        this.tablero = tablero;
        this.jugadores = jugadores;
        this.gestorDeTurno = new GestorDeTurno(jugadores);
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public Jugador jugadorEnTurnoActual() {
        return gestorDeTurno.turnoDe();
    }
}
