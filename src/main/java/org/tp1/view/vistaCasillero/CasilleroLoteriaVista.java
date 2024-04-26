package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroLoteria;
import org.tp1.view.Color;

public class CasilleroLoteriaVista extends CasilleroVista {

    private CasilleroLoteria casillero;

    public CasilleroLoteriaVista(CasilleroLoteria casillero) {
        this.casillero = casillero;
    }


    public void mostrarCasillero() {
        System.out.println(Color.BLUE.getColor() + "-------------------------" + Color.RESET.getColor());
        System.out.println(Color.YELLOW.getColor() + casillero.getNombre() + Color.RESET.getColor());
        if (casillero.getJugadores() != null) {
            for (Jugador jugador : casillero.getJugadores()) {
                System.out.println(Color.RED.getColor() + "\t|" + Color.RESET.getColor() + Color.GREEN.getColor() + "+ " + jugador.obtenerColor().getColor() + jugador.getNombre() + Color.RED.getColor() +"\t|" + Color.RESET.getColor());
            }
        }
        System.out.println(Color.YELLOW.getColor() + "\tCobrar: $" + casillero.getValorPozo()+ Color.RESET.getColor());
        System.out.println(Color.BLUE.getColor() + "-------------------------" + Color.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        this.mostrarOpcionesGenericas(jugador, null);
    }
}
