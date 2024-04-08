package org.tp1.controller;

import org.tp1.config.Configuracion;
import org.tp1.model.EstadoJugador;
import org.tp1.model.Juego;
import org.tp1.model.Jugador;
import org.tp1.view.JuegoVista;

import java.util.Scanner;

public class ControladorJuego {
    private Juego monopoly;
    private JuegoVista juegoVista;

    public ControladorJuego(Juego juego) {
        this.monopoly = juego;
        this.juegoVista = new JuegoVista(juego);
    }

    public boolean enJuego(){
        for(Jugador jugador: monopoly.getJugadores()) {
            if(!jugador.getEstadoJugador().equals(EstadoJugador.EN_JUEGO)) {
                return false;
            }
        }
        return true;
    }
    public void jugarTurno() {
        mostrarJuego();
        mostrarOpciones();
        elegirOpcion();
    }

    public void elegirOpcion() {
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        if(decision.equals("1")) {
            jugarTurno();
        }
    }

    public void mostrarOpciones(){
        juegoVista.mostrarOpciones();
    }

    public void mostrarJuego() {
        juegoVista.mostrarDatosJuego();
    }
}
