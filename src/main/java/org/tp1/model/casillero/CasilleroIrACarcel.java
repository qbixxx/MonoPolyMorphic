package org.tp1.model.casillero;

import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.comportamiento.ComportamientoIrACarcel;

import java.util.List;

public class CasilleroIrACarcel extends Casillero {
    public CasilleroIrACarcel(String nombre, TipoCasillero tipoCasillero) {
        super(nombre, tipoCasillero);
    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoIrACarcel();
    }
}
