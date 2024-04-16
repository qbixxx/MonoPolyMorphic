package org.tp1.model.casillero;

import org.tp1.model.Jugador;
import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.comportamiento.ComportamientoMulta;

import java.util.List;

public class CasilleroMulta extends Casillero {
    double valorMulta;

    public CasilleroMulta(String nombre, TipoCasillero tipoCasillero, double valorMulta, List<Jugador> jugadores) {
        super(nombre, tipoCasillero, jugadores);
        this.valorMulta = valorMulta;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoMulta();
    }
}