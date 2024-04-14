package org.tp1.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final String nombre;
    private double dineroDisponible;
    private List<Casillero> propiedades;
    private EstadoJugador estadoJugador;
    private int posicionActual;
    private Casillero casilleroActual;

    public Jugador(String nombre) {
        this.dineroDisponible = 100;
        this.nombre = nombre;
        this.propiedades = new ArrayList<>();
        this.estadoJugador = EstadoJugador.EN_JUEGO;
        this.posicionActual = 0;
        this.casilleroActual = null;
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

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int nuevaPosicion) {
        this.posicionActual = nuevaPosicion;
    }

    public void setDineroDisponible(double monto) {
        this.dineroDisponible += monto;
    }

    public double entregarDinero(double monto){
        this.dineroDisponible -= monto;
        // logica si queda negativo
        return monto;
    }
    public void recibirDinero(Jugador jugador, double monto){

        this.dineroDisponible += jugador.entregarDinero(monto);
    }

}
