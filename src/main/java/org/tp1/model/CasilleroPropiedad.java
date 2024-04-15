package org.tp1.model;


public class CasilleroPropiedad extends Casillero {
    String grupo;
    private double costoCompra;
    private double renta;
    private Jugador dueno;

    public CasilleroPropiedad(String nombre, TipoCasillero tipoCasillero, double costoCompra, double renta, String grupo) {
        super(nombre, tipoCasillero);
        this.grupo = grupo;
        this.costoCompra = costoCompra;
        this.renta = renta;
        this.dueno = null;

    }


    public String getGrupo() {
        return this.grupo;
    }

    public double getCostoCompra() {
        return this.costoCompra;
    }

    public double getRenta() {
        return this.renta;
    }

    public Jugador getDueno() {
        return this.dueno;
    }

    public void comprar(Jugador comprador) {
        this.dueno = comprador;
    }

    public void pagarRenta(Jugador inquilino) {
        if (this.dueno != null) {
            this.dueno.recibirDinero(inquilino, this.renta);
        }

    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoPropiedad();
    }
}