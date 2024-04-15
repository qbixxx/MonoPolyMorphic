package org.tp1.model;

import java.util.ArrayList;

public class CasilleroCarcel extends Casillero {

    public CasilleroCarcel(String nombre, TipoCasillero tipoCasillero) {
        super(nombre, tipoCasillero);
        this.jugadores = new ArrayList<>();
    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoPaso();
    }
}
