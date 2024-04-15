package org.tp1.view;

import org.tp1.model.Casillero;
import org.tp1.model.CasilleroEstacion;
import org.tp1.model.Jugador;

public class CasilleroVista {

    Casillero casillero;


    CasilleroVista(Casillero casillero) {
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
        if (casillero.getClass().equals(CasilleroEstacion.class))
            System.out.println("Presiona 1 para avanzar");
    }
}
