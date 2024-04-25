package org.tp1.model.juego.estadoJugador;

import org.tp1.model.juego.estadoJugador.EstadoJugador;

public interface State {
    EstadoJugador getEstado();
    void enJuego();
    void enCarcel();
    void enQuiebra();
}
