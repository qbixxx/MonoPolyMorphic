package org.tp1.model;

import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroPropiedad;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final String nombre;
    private double dineroDisponible;
    private List<Casillero> propiedades;
    private EstadoJugador estadoJugador;
    private int posicionActual;
    private Casillero casilleroActual;
    private String ultimoMensaje;

    public Jugador(String nombre) {
        this.dineroDisponible = 100;
        this.nombre = nombre;
        this.propiedades = new ArrayList<>();
        this.estadoJugador = EstadoJugador.EN_JUEGO;
        this.posicionActual = 0;
        this.casilleroActual = null;
    }

    public void setMensaje(String mensaje){
        this.ultimoMensaje = mensaje;
    }
    public String getUltimoMensaje(){
        String msg = this.ultimoMensaje;
        this.ultimoMensaje = "";
        return msg;

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

    public void setEstadoJugador(EstadoJugador estadoJugador) {
        this.estadoJugador = estadoJugador;
    }

    public double entregarDinero(double monto) {
        this.dineroDisponible -= monto;
        // logica si queda negativo
        return monto;
    }

    public void recibirDinero(Jugador jugador, double monto) {

        this.dineroDisponible += jugador.entregarDinero(monto);
    }

    public void agregarPropiedad(CasilleroPropiedad propiedad){
        this.propiedades.add(propiedad);
        this.dineroDisponible -= propiedad.getCostoCompra();

    }

}
