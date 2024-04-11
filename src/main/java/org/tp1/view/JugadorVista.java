package org.tp1.view;

import org.tp1.model.Jugador;
import org.tp1.model.casilleros.Casillero;

public class JugadorVista {

    private final Jugador jugador;

    public JugadorVista(Jugador jugador) {
        this.jugador = jugador;
    }

    public void mostrarJugador() {
        System.out.println(jugador.getNombre() + ", Dinero en cuenta: " + jugador.getDineroDisponible());
        System.out.println(jugador.getEstadoJugador()); // vista para el enum?
        String propiedades = "";
        if (jugador.getPropiedades() != null) {
            for (Casillero propiedad : jugador.getPropiedades()) {
                propiedades.concat(propiedad.getNombre() + ", ");
            }
        }
    }
}
