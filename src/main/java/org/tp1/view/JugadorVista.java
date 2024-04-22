package org.tp1.view;

import org.tp1.model.EstadoJugador;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;

public class JugadorVista {

    private final Jugador jugador;

    public JugadorVista(Jugador jugador) {
        this.jugador = jugador;
    }

    public void mostrarJugador() {
        System.out.println(jugador.getNombre() + ", Dinero en cuenta: " + jugador.getDineroDisponible()+ " : "+colorEstado(jugador.getEstadoJugador()) + jugador.getEstadoJugador() + Colores.RESET.getColor());
        //System.out.println(colorEstado(jugador.getEstadoJugador()) + jugador.getEstadoJugador() + Colores.RESET.getColor());
        String propiedades = "";
        if (jugador.getPropiedades() != null) {
            for (Casillero propiedad : jugador.getPropiedades()) {
                propiedades.concat(propiedad.getNombre() + ", ");
            }
        }
    }


    private String colorEstado(EstadoJugador estado) {
        return estado == EstadoJugador.EN_JUEGO ? Colores.GREEN.getColor() : (estado == EstadoJugador.ENCARCELADO ? Colores.YELLOW.getColor() : Colores.RED.getColor());
    }
}