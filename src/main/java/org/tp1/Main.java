package org.tp1;

import org.tp1.config.Configuracion;
import org.tp1.controller.ControladorJuego;
import org.tp1.controller.EstadoJuego;
import org.tp1.model.Jugador;
import org.tp1.model.juego.Juego;
import org.tp1.model.juego.Tablero;

public class Main {
    public static void main(String[] args) {

        Configuracion configuracion = new Configuracion();

        Jugador jugador1 = new Jugador("Valentin");
        Jugador jugador2 = new Jugador("Lautaro");
        Jugador jugador3 = new Jugador("Julian");
        Jugador jugador4 = new Jugador("Juan");

        Jugador[] jugadores = {jugador1, jugador2, jugador3, jugador4};

        Tablero tablero = new Tablero(configuracion.getTablero());

        Juego monopoly = new Juego(tablero, jugadores);

        ControladorJuego controladorJuego = new ControladorJuego(monopoly, EstadoJuego.TURNO_JUGADOR);

        while (controladorJuego.enJuego()) {
            controladorJuego.jugarTurno();
        }
    }
}