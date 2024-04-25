package org.tp1.model.juego.estadoJugador;

import org.tp1.model.*;

public class enCarcelState implements State {
    private Jugador jugador;
    private EstadoJugador estado = EstadoJugador.ENCARCELADO;

    public enCarcelState(Jugador jugador){
        this.jugador = jugador;
    }
    public EstadoJugador getEstado() {
        return estado;
    }
    public void enJuego() {
        this.jugador.setEstado(new enJuegoState(this.jugador));
    }
    public void enCarcel() {
        System.out.println(this.jugador.getNombre() + " ya esta en la Carcel");
    }
    public void enQuiebra() {
        if(this.jugador.getDineroDisponible() <= 0){
            this.jugador.setEstado(new enQuiebraState(this.jugador));
            System.out.println("Quebraste desde la carcel");
        }
    }
}
