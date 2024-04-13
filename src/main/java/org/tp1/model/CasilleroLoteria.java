package org.tp1.model;

public class CasilleroLoteria extends Casillero{

    double monto;

    public CasilleroLoteria(String nombre, double monto){
        super(nombre);
        this.monto = monto;
    }

    public double cobrarPozo(){
        return this.monto;
    }

}
