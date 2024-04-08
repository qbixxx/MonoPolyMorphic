package org.tp1.view;

import org.tp1.model.Casillero;

import java.util.Arrays;

public class CasilleroVista {

    private Casillero casillero;

    public CasilleroVista(Casillero casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(casillero.getNombre());
        if (casillero.getJugadores() != null) {
            System.out.println(Arrays.toString(casillero.getJugadores()));
        }
    }
}
