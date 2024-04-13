package org.tp1.model;


public class CasilleroPropiedad extends Casillero{
    String grupo;
    double costoCompra;
    double renta;
    Jugador dueno;

    public CasilleroPropiedad(String nombre, double costoCompra, double renta, String grupo){
        super(nombre);
        this.grupo = grupo;
        this.costoCompra = costoCompra;
        this.renta = renta;
        this.dueno = null;

    }



    //public void mostrarOpcionesCasillero() {
    //    System.out.println("Presiona 1 para avanzar");
   // }


}