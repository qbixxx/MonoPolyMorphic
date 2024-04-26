package org.tp1.model.casillero;

import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.comportamiento.ComportamientoLoteria;

public class CasilleroLoteria extends Casillero {

    double monto;

    public CasilleroLoteria(String nombre, TipoCasillero tipoCasillero, double monto) {
        super(nombre, tipoCasillero);
        this.monto = monto;
    }

    public double obtenerValorPozo() {
        return this.monto;
    }

    public ComportamientoCasilla obtenerComportamientoCasilla() {
        return new ComportamientoLoteria();
    }
}
