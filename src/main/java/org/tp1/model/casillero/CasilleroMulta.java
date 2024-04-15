package org.tp1.model.casillero;

import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.comportamiento.ComportamientoMulta;

public class CasilleroMulta extends Casillero {
    double valorMulta;

    public CasilleroMulta(String nombre, TipoCasillero tipoCasillero, double valorMulta) {
        super(nombre, tipoCasillero);
        this.valorMulta = valorMulta;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoMulta();
    }
}