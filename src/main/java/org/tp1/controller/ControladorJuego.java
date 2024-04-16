package org.tp1.controller;

import org.tp1.model.EstadoJugador;
import org.tp1.model.Juego;
import org.tp1.model.Jugador;
import org.tp1.view.JuegoVista;

import java.util.Scanner;

public class ControladorJuego {
    private final Juego monopoly;
    private final JuegoVista juegoVista;

    public ControladorJuego(Juego juego) {
        this.monopoly = juego;
        this.juegoVista = new JuegoVista(juego);
    }

    public boolean enJuego() {
        int numJugadoresEnJuego = 0;
        for (Jugador jugador : monopoly.getJugadores()) {
            if (jugador.getEstadoJugador().equals(EstadoJugador.EN_JUEGO)) {
                numJugadoresEnJuego++;
            }
        }
        return numJugadoresEnJuego >= 2;
    }

    public void jugarTurno() {
        juegoVista.mostrarDatosJuego();
        juegoVista.mostrarOpciones();
        elegirOpcion();
    }

    public void elegirOpcion() {
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        if (!monopoly.jugadorEnTurnoActual().getEstadoJugador().equals(EstadoJugador.ENCARCELADO)) {
            if (decision.equals(Comandos.AVANZAR.getComando())) {
                monopoly.avanzar();
                monopoly.siguienteTurno();
            } else if (decision.equals(Comandos.SIG_TURNO.getComando())) {
                monopoly.siguienteTurno();
            } else {
                System.out.println("Esta accion no existe");
            }
        } else {
            if (decision.equals(Comandos.AVANZAR.getComando())) {
                monopoly.pasarTurnoEnCarcel();
            }
        }
    }
}
