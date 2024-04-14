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


    public String getGrupo(){
        return this.grupo;
    }

    public double getCostoCompra(){
        return this.costoCompra;
    }

    public double getRenta(){
        return this.renta;
    }

    public Jugador getDueno(){
        return this.dueno;
    }

    public void comprar(Jugador comprador){
        this.dueno = comprador;
    }

    public void pagarRenta(Jugador inquilino){
        if(this.dueno != null){
            this.dueno.recibirDinero(inquilino.entregarDinero(this.renta));
        }

    }


    //public void mostrarOpcionesCasillero() {
    //    System.out.println("Presiona 1 para avanzar");
   // }


}