package org.tp1.model.casillero;

import org.tp1.model.Jugador;
import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.comportamiento.ComportamientoPaso;

import java.util.List;

public class CasilleroPaso extends Casillero {
    public CasilleroPaso(String nombre, TipoCasillero tipoCasillero, List<Jugador> jugadores) {
        super(nombre, tipoCasillero, jugadores);
    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoPaso();
    }
}
