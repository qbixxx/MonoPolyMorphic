package org.tp1.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private double dineroDisponible;
    private List<Casillero> propiedades; // cambiar a casillero propiedades
    private EstadoJugador estadoJugador;
    //private int posicionActual;

    public Jugador(String nombre) {
        this.dineroDisponible = 100;
        this.nombre = nombre;
        this.propiedades = new ArrayList<>();
        this.estadoJugador = EstadoJugador.EN_JUEGO;
        //this.posicionActual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDineroDisponible() {
        return dineroDisponible;
    }

    public List<Casillero> getPropiedades() {
        return propiedades;
    }

    public EstadoJugador getEstadoJugador() {
        return estadoJugador;
    }
}
