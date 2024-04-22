package org.tp1.model;

import org.tp1.model.casillero.Casillero;
import org.tp1.model.juego.estadoJugador.EstadoJugador;
import org.tp1.model.juego.estadoJugador.State;
import org.tp1.model.juego.estadoJugador.enJuegoState;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private final String nombre;
    private double dineroDisponible;
    private List<Casillero> propiedades;
    private int posicionActual;
    private Casillero casilleroActual;
    private State estado;

    public Jugador(String nombre) {
        this.dineroDisponible = 100;
        this.nombre = nombre;
        this.propiedades = new ArrayList<>();
        this.posicionActual = 0;
        this.casilleroActual = null;
        this.estado = new enJuegoState(this);
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
        return this.estado.getEstado();
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
    public double entregarDinero(double monto) {
        this.dineroDisponible -= monto;
        // logica si queda negativo
        return monto;
    }
    public void setEstado(State estado){
        this.estado = estado;
    }
    public void enJuego(){
        this.estado.enJuego();
    }
    public void enCarcel(){
        this.estado.enCarcel();
    }
    public void enQuiebra(){
        this.estado.enQuiebra();
    }
    public void recibirDinero(Jugador jugador, double monto) {

        this.dineroDisponible += jugador.entregarDinero(monto);
    }
    public Casillero getCasilleroActual() {
        return casilleroActual;
    }
    public void setCasilleroActual(Casillero casilleroActual) {
        this.casilleroActual = casilleroActual;
    }
    public State getEstado() {
        return estado;
    }
}
