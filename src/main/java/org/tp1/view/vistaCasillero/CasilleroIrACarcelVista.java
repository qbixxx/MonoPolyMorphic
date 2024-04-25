package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroIrACarcel;
import org.tp1.view.Colores;

public class CasilleroIrACarcelVista extends CasilleroVista {

    private final CasilleroIrACarcel casillero;

    public CasilleroIrACarcelVista(CasilleroIrACarcel casillero) {
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
        System.out.println(Colores.RED.getColor() + "Ir directo a la cárcel" + Colores.RESET.getColor());
        System.out.println(Colores.BLUE.getColor() + "--------------------" + Colores.RESET.getColor());
    }
    
    public void mostrarOpcionesCasillero(Jugador jugador) {

        System.out.println("Opciones casillero ir a carcel");
        System.out.println("1 1- terminar Turno");
    }
}
