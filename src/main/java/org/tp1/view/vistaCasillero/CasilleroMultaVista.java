package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroMulta;
import org.tp1.view.Color;

public class CasilleroMultaVista extends CasilleroVista {

    private CasilleroMulta casillero;

    public CasilleroMultaVista(CasilleroMulta casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
        System.out.println(Color.YELLOW.getColor() + casillero.obtenerNombre() + Color.RESET.getColor());
        if (casillero.obtenerJugadores() != null) {
            for (Jugador jugador : casillero.obtenerJugadores()) {
                System.out.println(Color.RED.getColor() + "\t|" + Color.RESET.getColor() + Color.GREEN.getColor() + "+ " + Color.RESET.getColor() + jugador.obtenerColor().getColor() + jugador.obtenerNombre() + "\t|" + Color.RESET.getColor());
            }
        }
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        this.mostrarOpcionesGenericas(jugador, null);
    }
}
