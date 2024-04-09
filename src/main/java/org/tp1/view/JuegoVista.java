package org.tp1.view;

import org.tp1.model.Juego;
import org.tp1.model.Jugador;
import org.tp1.model.Tablero;

public class JuegoVista {

    private final Juego juego;

    public JuegoVista(Juego juego) {
        this.juego = juego;
    }

    public void mostrarDatosJuego() { // modularizar
        TableroVista tableroVista = new TableroVista(juego.getTablero());
        tableroVista.mostrarTablero();
        for (Jugador jugador : juego.getJugadores()) {
            JugadorVista jugadorVista = new JugadorVista(jugador);
            jugadorVista.mostrarJugador();
        }
        Jugador jugadorEnTurno = juego.jugadorEnTurnoActual();
        System.out.println("Turno de: " + jugadorEnTurno.getNombre() + ", dinero disponible: " + jugadorEnTurno.getDineroDisponible());
    }

    public void mostrarOpciones() {
        Tablero tablero = juego.getTablero();
        TableroVista tableroVista = new TableroVista(tablero);
        tableroVista.mostrarOpciones(tablero.getCasilleros()[juego.jugadorEnTurnoActual().getPosicionActual()]);
    }
}
