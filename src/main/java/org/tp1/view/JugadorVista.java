package org.tp1.view;

import org.tp1.model.Casillero;
import org.tp1.model.Jugador;

public class JugadorVista {

    private Jugador jugador;

    public JugadorVista(Jugador jugador) {
        this.jugador = jugador;
    }

    public void mostrarJugador() {
        System.out.println(jugador.getNombre());
        System.out.println(jugador.getEstadoJugador());
        System.out.println(jugador.getDineroDisponible());
        if (jugador.getPropiedades() != null) {
            for (Casillero propiedad : jugador.getPropiedades()) {
                System.out.println(propiedad);
            }
        }
    }
}
