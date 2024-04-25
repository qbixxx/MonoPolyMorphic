package org.tp1.model.casillero;

import org.tp1.model.Jugador;
import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.comportamiento.ComportamientoTransporte;

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

    public void comprar(Jugador comprador) {
        this.dueno = comprador;
        comprador.agregarTransporte(this);
    }

    public void vender(Jugador vendedor) {
        this.dueno = null;
        vendedor.venderTransporte(this);

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
