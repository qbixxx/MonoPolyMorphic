package org.tp1.model.juego.estadoJugador;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.TipoCasillero;

public class enJuegoState implements State {
    private Jugador jugador;
    private EstadoJugador estado = EstadoJugador.EN_JUEGO;

    public enJuegoState(Jugador jugador){
        this.jugador = jugador;
    }
    public EstadoJugador getEstado() {
        return estado;
    }
    public void enJuego() {
        System.out.println(this.jugador.obtenerNombre() +" ya está en Juego");
    }
    public void enCarcel() {
        if(this.jugador.obtenerCasilleroActual().getTipoCasillero() == TipoCasillero.IR_A_CARCEL ){
            this.jugador.setEstado(new enCarcelState(this.jugador));
            System.out.println("Va pa' la carcel");
        }
    }
    public void enQuiebra() {
        if(this.jugador.obtenerDineroDisponible() <= 0){
            this.jugador.setEstado(new enQuiebraState(this.jugador));
            System.out.println("quebraste loco en el juego!");
        }
    }
}
