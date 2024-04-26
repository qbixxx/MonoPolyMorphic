package org.tp1.view;

import org.tp1.model.casillero.CasilleroTransporte;
import org.tp1.model.juego.estadoJugador.EstadoJugador;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroPropiedad;

public class JugadorVista {

    private final Jugador jugador;

    public JugadorVista(Jugador jugador) {
        this.jugador = jugador;
    }

    public void mostrarJugador() {
        System.out.printf(jugador.obtenerColor().getColor() + jugador.obtenerNombre() + Color.RESET.getColor() + ", " +
                "Dinero en " +
                "cuenta: " + jugador.obtenerDineroDisponible()+
                " :" +
                " "+colorEstado(jugador.obtenerEstadoJugador()) + jugador.obtenerEstadoJugador()+ Color.RESET.getColor());
        String msg = jugador.obtenerUltimoMensaje();
        if (msg == null){
            System.out.println(Color.BLUE.getColor()+ " Ultimo mensaje: -"+ Color.RESET.getColor());
        }else{
            System.out.println(Color.BLUE.getColor()+ " Ultimo mensaje: "+ msg+ Color.RESET.getColor());
        }

        System.out.printf("L___ Propiedades:");
        for (CasilleroPropiedad propiedad : jugador.obtenerPropiedades()){
            System.out.printf(propiedad.obtenerNombre()+"\t");
        }
        System.out.println("\n");
        System.out.printf("L___ Transportes:");
        for (CasilleroTransporte transporte: jugador.obtenerTransportes()) {
            System.out.println(transporte.obtenerNombre()+"\t");
        }
        System.out.println("");

        String propiedades = "";
        if (jugador.obtenerPropiedades() != null) {
            for (Casillero propiedad : jugador.obtenerPropiedades()) {
                propiedades.concat(propiedad.obtenerNombre() + ", ");
            }
        }
    }

    private String colorEstado(EstadoJugador estado) {
        return estado == EstadoJugador.EN_JUEGO ? Color.GREEN.getColor() : (estado == EstadoJugador.ENCARCELADO ? Color.YELLOW.getColor() : Color.RED.getColor());
    }
}