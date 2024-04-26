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
        System.out.printf(jugador.getNombre() + ", Dinero en cuenta: " + jugador.getDineroDisponible()+ " : "+colorEstado(jugador.getEstadoJugador()) + jugador.getEstadoJugador()+ Color.RESET.getColor());
        String msg = jugador.getUltimoMensaje();
        if (msg == null){
            System.out.println(Color.BLUE.getColor()+ " Ultimo mensaje: -"+ Color.RESET.getColor());
        }else{
            System.out.println(Color.BLUE.getColor()+ " Ultimo mensaje: "+ msg+ Color.RESET.getColor());
        }

        System.out.printf("L___ Propiedades:");
        for (CasilleroPropiedad propiedad : jugador.getPropiedades()){
            System.out.printf(propiedad.getNombre()+"\t");
        }
        System.out.println("\n");
        System.out.printf("L___ Transportes:");
        for (CasilleroTransporte transporte: jugador.obtenerTransportes()) {
            System.out.println(transporte.getNombre()+"\t");
        }
        System.out.println("");

        //System.out.println(colorEstado(jugador.getEstadoJugador()) + jugador.getEstadoJugador() + Colores.RESET.getColor());
        String propiedades = "";
        if (jugador.getPropiedades() != null) {
            for (Casillero propiedad : jugador.getPropiedades()) {
                propiedades.concat(propiedad.getNombre() + ", ");
            }
        }
    }

    private String colorEstado(EstadoJugador estado) {
        return estado == EstadoJugador.EN_JUEGO ? Color.GREEN.getColor() : (estado == EstadoJugador.ENCARCELADO ? Color.YELLOW.getColor() : Color.RED.getColor());
    }
}