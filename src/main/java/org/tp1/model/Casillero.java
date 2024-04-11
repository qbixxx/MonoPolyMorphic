package org.tp1.model;

public class Casillero {
    String nombre;
    Jugador[] jugadores;
    String tipoCasillero;

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
