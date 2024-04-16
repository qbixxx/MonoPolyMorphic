package org.tp1.model.casillero;

import org.tp1.model.Jugador;
import org.tp1.model.comportamiento.ComportamientoCasilla;

import java.util.List;

public abstract class Casillero {
    private final String nombre;
    protected List<Jugador> jugadores;
    private final TipoCasillero tipoCasillero;

    public Casillero(String nombre, TipoCasillero tipoCasillero, List<Jugador> jugadores) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.tipoCasillero = tipoCasillero;
    }

    public TipoCasillero getTipoCasillero() {
        return tipoCasillero;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public abstract ComportamientoCasilla getComportamientoCasilla();
}
