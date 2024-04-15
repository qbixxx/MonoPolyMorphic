package org.tp1.model;

public class CasilleroTransporte extends Casillero {

    private final double costoCompra;
    private double tarifa;
    private Jugador dueno;

    public CasilleroTransporte(String nombre, TipoCasillero tipoCasillero, double costoCompra, double tarifa) {
        super(nombre, tipoCasillero);
        this.costoCompra = costoCompra;
        this.tarifa = tarifa;
        this.dueno = null;
    }

    public double getTarifa() {
        return this.tarifa;
    }

    public Jugador getDueno() {
        return this.dueno;
    }

    public double getCostoCompra() {
        return this.costoCompra;
    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoTransporte();
    }
}
