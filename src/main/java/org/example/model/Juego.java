package org.example.model;

import org.example.configuracion.Configuracion;
import org.example.model.jugador.JuegoObserver;
import org.example.model.jugador.Jugador;
import org.example.model.use_case.OpcionableQuebrado;

import java.util.ArrayList;
import java.util.List;

public class Juego implements JuegoObserver {

    private Banco banco;
    private List<Jugador> jugadores;

    private GestorDeTurno gestorDeTurno;

    private Jugador jugadorEnTurno;

    private Tablero tablero;

    public Juego() {
        this.jugadores = new ArrayList<>();
        this.banco = new Banco(Configuracion.montoPorRondaCompleta);
    }

    public void agregarJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.tablero = new Tablero(Configuracion.casillas, jugadores, banco);
        this.jugadores.forEach(jugador -> {
            jugador.agregarJuegoObserver(this);
        });
        this.gestorDeTurno = new GestorDeTurno(jugadores);
        iniciarPartida();
        this.cambiarTurno();
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public void ejecutarOpcionableDelJugadorDeTurno() {
        this.jugadorEnTurno.ejecutarOpcionable();
    }
    public void iniciarPartida() {
        Logger.getInstance().info("Partida iniciada");
        for (Jugador jugador: this.jugadores)
            this.banco.pagarRondaCompletaA(jugador);
    }

    public void ejecutarTurno() {
        this.tablero.mover(this.jugadorEnTurno, this.jugadorEnTurno.tirarDado());
    }
    public void cambiarTurno() {
        this.jugadorEnTurno = this.gestorDeTurno.turnoDe();
    }

    public boolean hayGanador() {
        return this.jugadores.size() == 1;
    }

    public Jugador getJugadorEnTurno() {
        return this.jugadorEnTurno;
    }

    public void eliminarJugadorQuebrado() {
        this.jugadorEnTurno.rematarPropiedades();
        this.gestorDeTurno.eliminarJugador(this.jugadorEnTurno);
    }

    @Override
    public void notificarQuiebra() {
        this.jugadorEnTurno.agregarOpcionable(new OpcionableQuebrado(this));
    }
}
