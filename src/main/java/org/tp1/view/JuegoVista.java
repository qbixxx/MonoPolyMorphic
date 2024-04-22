package org.tp1.view;

import org.tp1.model.Jugador;
import org.tp1.model.juego.Juego;
import org.tp1.model.juego.Tablero;

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
        System.out.println(Colores.RED.getColor() + "------------------------------\n" + Colores.RESET.getColor() + "Turno de: " + Colores.GREEN.getColor() + jugadorEnTurno.getNombre() + Colores.RESET.getColor() + ",\n" + Colores.YELLOW.getColor() + "dinero disponible: " + jugadorEnTurno.getDineroDisponible() + Colores.RESET.getColor() + Colores.RED.getColor() + "\n------------------------------" + Colores.RESET.getColor());
    }

    public void mostrarOpciones() {
        Tablero tablero = juego.getTablero();
        TableroVista tableroVista = new TableroVista(tablero);
        tableroVista.mostrarOpciones(juego.jugadorEnTurnoActual());
    }
}
