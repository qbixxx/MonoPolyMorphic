package org.tp1.model;

import java.util.ArrayList;
import java.util.List;

public class Casillero {
    private final String nombre;
    private List<Jugador> jugadores;
    private final TipoCasillero tipoCasillero;

    public Casillero(String nombre, TipoCasillero tipoCasillero) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
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
}
