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
        System.out.println(Color.YELLOW.getColor() + casilleroPaso.obtenerNombre() + Color.RESET.getColor());
        if (casilleroPaso.obtenerJugadores() != null) {
            for (Jugador jugador : casilleroPaso.obtenerJugadores()) {
                System.out.println(Color.RED.getColor() + "\t|" + Color.RESET.getColor() + Color.GREEN.getColor() + "+ " + Color.RESET.getColor() + jugador.obtenerColor().getColor() + jugador.obtenerNombre() + "\t|" + Color.RESET.getColor());
            }
        }
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        this.mostrarOpcionesGenericas(jugador, null);
    }
}
