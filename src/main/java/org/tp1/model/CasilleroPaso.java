package org.tp1.model;

import java.util.ArrayList;

public class CasilleroPaso extends Casillero {
    public CasilleroPaso(String nombre, TipoCasillero tipoCasillero) {
        super(nombre, tipoCasillero);
        this.jugadores = new ArrayList<>();
    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoPaso();
    }
}
