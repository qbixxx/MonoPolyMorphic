package org.tp1.model;

import java.util.Random;

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

    public void avanzar() {
        Random rand = new Random();
        int dado = rand.nextInt(4);
        Jugador jugador = jugadorEnTurnoActual();
        int posicionAnterior = jugador.getPosicionActual();
        jugador.setPosicionActual(jugador.getPosicionActual() + dado);
        if (jugador.getPosicionActual() >= tablero.tablero.length) {
            jugador.setPosicionActual(3);
        }
        tablero.getCasillero(jugador.getPosicionActual()).agregarJugador(jugador);
        tablero.getCasillero(posicionAnterior).eliminarJugador(jugador);
    }

}
