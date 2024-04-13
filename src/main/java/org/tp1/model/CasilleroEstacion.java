package org.tp1.model;

public class CasilleroEstacion extends Casillero {

    double costoCompra;
    double tarifa;
    Jugador dueno;

    public CasilleroEstacion(String nombre, double costoCompra, double tarifa){
        super(nombre);
        this.costoCompra = costoCompra;
        this.tarifa = tarifa;
        this.dueno = null;
    }





}
