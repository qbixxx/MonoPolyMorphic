package org.tp1.model.juego.estadoJugador;

import org.tp1.model.Jugador;

public class enQuiebraState implements State {
    private Jugador jugador;
    private EstadoJugador estado = EstadoJugador.EN_QUIEBRA;
    public enQuiebraState(Jugador jugador){
        this.jugador = jugador;
    }
    public EstadoJugador getEstado() {
        return estado;
    }
    public void enJuego() {
        System.out.println(this.jugador.getNombre() + " Ya habias quedado afuera del juego por quebrar");
    }
    public void enCarcel() {
        System.out.println(this.jugador.getNombre() + " ya habias quebrado, no podes estar en carcel");
    }
    public void enQuiebra() {
        System.out.println("Ya habias quebrado");
    }
}
