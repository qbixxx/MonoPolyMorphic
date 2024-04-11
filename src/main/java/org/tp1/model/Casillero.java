package org.tp1.model;

import java.util.ArrayList;
import java.util.List;

public class Casillero {
    String nombre;
    List<Jugador> jugadores;
    String tipoCasillero;

    public Casillero(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
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

    /*
    public void mostrarCasillero() {
        System.out.println(nombre);
        if (jugadores != null) {
            for (Jugador jugador : jugadores) {
                System.out.println(jugador.getNombre());
            }
        }
    }

     */

    public void mostrarOpcionesCasillero() {
        System.out.println("Presiona 1 para avanzar");
    }
}
