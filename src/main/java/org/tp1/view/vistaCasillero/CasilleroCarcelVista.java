package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroCarcel;
import org.tp1.view.Colores;

public class CasilleroCarcelVista implements CasilleroVista {

    CasilleroCarcel casillero;

    public CasilleroCarcelVista(CasilleroCarcel casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Colores.BLUE.getColor() + "--------------------" + Colores.RESET.getColor());
        System.out.println(Colores.YELLOW.getColor() + casillero.getNombre() + Colores.RESET.getColor());
        if (casillero.getJugadores() != null) {
            for (Jugador jugador : casillero.getJugadores()) {
                System.out.println(Colores.RED.getColor() + "\t|" + Colores.RESET.getColor() + Colores.GREEN.getColor() + "+ " + Colores.RESET.getColor() + Colores.RED.getColor() + jugador.getNombre() + "\t|" + Colores.RESET.getColor());
            }
        }
        System.out.println(Colores.BLUE.getColor() + "--------------------" + Colores.RESET.getColor());
    }

    public void mostrarOpcionesCasillero() {
        System.out.println("Opciones casillero carcel");
    }
}
