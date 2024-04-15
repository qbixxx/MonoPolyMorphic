package org.tp1.model;

public class CasilleroLoteria extends Casillero {

    double monto;

    public CasilleroLoteria(String nombre, TipoCasillero tipoCasillero, double monto) {
        super(nombre, tipoCasillero);
        this.monto = monto;
    }

    public double getValorPozo() {
        return this.monto;
    }

}
