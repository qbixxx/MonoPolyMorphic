package org.tp1.model;

public class Casillero {
    String nombre;
    Jugador[] jugadores;

    public Casillero(String nombre) {
        this.nombre = nombre;
        this.jugadores = null;
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }
}
