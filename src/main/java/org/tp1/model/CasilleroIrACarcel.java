package org.tp1.model;

import java.util.ArrayList;

public class CasilleroIrACarcel extends Casillero {
    public CasilleroIrACarcel(String nombre, TipoCasillero tipoCasillero) {
        super(nombre, tipoCasillero);
        this.jugadores = new ArrayList<>();
    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoIrACarcel();
    }
}
