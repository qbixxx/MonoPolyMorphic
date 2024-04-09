package org.tp1.model;

import org.tp1.view.CasilleroVista;

public class Casillero implements CasilleroVista {
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

    @Override
    public void mostrarCasillero() {
        System.out.println(nombre);
        if (jugadores != null) {
            for (Jugador jugador : jugadores) {
                System.out.println(jugador.getNombre());
            }
        }
    }

    @Override
    public void mostrarOpcionesCasillero() {
        System.out.println("Presiona 1 para avanzar");
    }
}
