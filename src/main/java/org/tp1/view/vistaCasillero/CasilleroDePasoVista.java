package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroPaso;
import org.tp1.view.Colores;

public class CasilleroDePasoVista implements CasilleroVista {

    CasilleroPaso casilleroPaso;

    public CasilleroDePasoVista(CasilleroPaso casillero) {
        this.casilleroPaso = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Colores.BLUE.getColor() + "--------------------" + Colores.RESET.getColor());
        System.out.println(Colores.YELLOW.getColor() + casilleroPaso.getNombre() + Colores.RESET.getColor());
        if (casilleroPaso.getJugadores() != null) {
            for (Jugador jugador : casilleroPaso.getJugadores()) {
                System.out.println(Colores.RED.getColor() + "\t|" + Colores.RESET.getColor() + Colores.GREEN.getColor() + "+ " + Colores.RESET.getColor() + Colores.RED.getColor() + jugador.getNombre() + "\t|" + Colores.RESET.getColor());
            }
        }
        System.out.println(Colores.BLUE.getColor() + "--------------------" + Colores.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        System.out.println("🚶 "+jugador.getNombre()+"! Estás en un casillero de paso, aqui no pasa nada :)");

        /*
        * Agregar la logica segun el estado del jugador.
        *
        * Ya sea:
        * Hipotecar, construir, vender, etc
        * Expandir a los demas casilleros
        *
        * */
    }
}
