package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroPaso;
import org.tp1.view.Color;

public class CasilleroDePasoVista extends CasilleroVista {

    CasilleroPaso casilleroPaso;

    public CasilleroDePasoVista(CasilleroPaso casillero) {
        this.casilleroPaso = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
        System.out.println(Color.YELLOW.getColor() + casilleroPaso.getNombre() + Color.RESET.getColor());
        if (casilleroPaso.getJugadores() != null) {
            for (Jugador jugador : casilleroPaso.getJugadores()) {
                System.out.println(Color.RED.getColor() + "\t|" + Color.RESET.getColor() + Color.GREEN.getColor() + "+ " + Color.RESET.getColor() + Color.RED.getColor() + jugador.getNombre() + "\t|" + Color.RESET.getColor());
            }
        }
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        this.mostrarOpcionesGenericas(jugador, null);
    }
}
