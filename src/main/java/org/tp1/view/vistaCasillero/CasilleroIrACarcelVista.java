package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroIrACarcel;
import org.tp1.view.Color;

public class CasilleroIrACarcelVista extends CasilleroVista {

    private final CasilleroIrACarcel casillero;

    public CasilleroIrACarcelVista(CasilleroIrACarcel casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
        System.out.println(Color.YELLOW.getColor() + casillero.getNombre() + Color.RESET.getColor());
        if (casillero.getJugadores() != null) {
            for (Jugador jugador : casillero.getJugadores()) {
                System.out.println(Color.RED.getColor() + "\t|" + Color.RESET.getColor() + Color.GREEN.getColor() + "+ " + Color.RESET.getColor() + Color.RED.getColor() + jugador.getNombre() + "\t|" + Color.RESET.getColor());
            }
        }
        System.out.println(Color.RED.getColor() + "Ir directo a la cárcel" + Color.RESET.getColor());
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
    }
    
    public void mostrarOpcionesCasillero(Jugador jugador) {
    }
}
