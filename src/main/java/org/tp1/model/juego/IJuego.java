package org.tp1.model.juego;

import org.tp1.model.Jugador;

public interface IJuego {

    Jugador jugadorEnTurnoActual();

    void siguienteTurno();

    Tablero getTablero();

    Jugador[] getJugadores();

    void pasarTurnoEnCarcel();

    void avanzar();

    void encarcelarJugador(Jugador jugador, int posicionAnterior);

    void liberarJugador(Jugador jugador);

    void moverJugador(Jugador jugador, int posicionAnterior);

    void setearPosicion(Jugador jugador);

    boolean pasoPorSalida(Jugador jugador);

    void cobro(Jugador jugador, double monto);


}
