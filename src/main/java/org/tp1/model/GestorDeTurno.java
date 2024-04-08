package org.tp1.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GestorDeTurno {

    int posicionJugadorDeTurno;
    Jugador[] ordenJugadores;

    public GestorDeTurno(Jugador[] jugadores){
        this.posicionJugadorDeTurno = 0;
        this.ordenJugadores = desordenarJugadores(jugadores);
    }

    public Jugador[] desordenarJugadores(Jugador[] jugadores) {
        Jugador[] copiaJugadores = jugadores.clone();
        List<Jugador> jugadorList = Arrays.asList(copiaJugadores);
        Collections.shuffle(jugadorList);
        jugadorList.toArray(copiaJugadores);
        return copiaJugadores;
    }
    public Jugador turnoDe() {
        Jugador jugadorEnTurno = ordenJugadores[posicionJugadorDeTurno];
        posicionJugadorDeTurno += 1;
        return jugadorEnTurno;
    }


}
