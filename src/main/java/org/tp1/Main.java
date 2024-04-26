package org.tp1;

import org.tp1.config.Configuracion;
import org.tp1.controller.ControladorJuego;
import org.tp1.controller.EstadoJuego;
import org.tp1.model.Jugador;
import org.tp1.model.juego.Juego;
import org.tp1.model.juego.Tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Jugador> crearJugadores(Scanner scanner, int cantidadDeJugadores) {
        List<Jugador> jugadores = new ArrayList<>(cantidadDeJugadores);
        for (int i = 0; i < cantidadDeJugadores; i++) {
            System.out.print("Ingresa el nombre del jugador: ");
            String nombreJugador = scanner.nextLine();
            Jugador jugador = new Jugador(nombreJugador);
            jugadores.add(jugador);
        }
        return jugadores;
    }
    public static void main(String[] args) {

        Configuracion configuracion = new Configuracion();
        Scanner scanner = new Scanner(System.in);
        int cantidadJugadores = 0;
        do {
            System.out.print("Ingresa la cantidad de jugadores: ");
            String cantidadJugadoresTexto = scanner.nextLine();
            cantidadJugadores = Integer.parseInt(cantidadJugadoresTexto);

        } while (cantidadJugadores < 2 || cantidadJugadores > 4);
        List<Jugador> jugadores = crearJugadores(scanner, cantidadJugadores);

        Tablero tablero = new Tablero(configuracion.getTablero());

        Juego monopoly = new Juego(tablero, jugadores);

        ControladorJuego controladorJuego = new ControladorJuego(monopoly, EstadoJuego.TURNO_JUGADOR);

        while (controladorJuego.enJuego()) {
            controladorJuego.jugarTurno();
        }

        scanner.close();
    }
}