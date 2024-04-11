package org.tp1.view;

import org.tp1.model.Casillero;
import org.tp1.model.Jugador;

public class CasilleroVista {

    Casillero casillero;


    CasilleroVista(Casillero casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(casillero.getNombre());
        if (casillero.getJugadores() != null) {
            for (Jugador jugador : casillero.getJugadores()) {
                System.out.println(jugador.getNombre());
            }
        }

    }

    //void mostrarOpcionesCasillero();
}
