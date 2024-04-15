package org.tp1.model.casillero;

import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.comportamiento.ComportamientoPaso;

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
