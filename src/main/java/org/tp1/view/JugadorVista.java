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
        System.out.printf(jugador.getNombre() + ", Dinero en cuenta: " + jugador.getDineroDisponible()+ " : "+colorEstado(jugador.getEstadoJugador()) + jugador.getEstadoJugador()+Colores.RESET.getColor());
        String msg = jugador.getUltimoMensaje();
        if (msg == null){
            System.out.println(Colores.BLUE.getColor()+ " Ultimo mensaje: -"+ Colores.RESET.getColor());
        }else{
            System.out.println(Colores.BLUE.getColor()+ " Ultimo mensaje: "+ msg+ Colores.RESET.getColor());
        }

        System.out.printf("L___ Propiedades:");
        for (CasilleroPropiedad propiedad : jugador.getPropiedades()){
            System.out.printf(propiedad.getNombre()+"\t");
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
        return estado == EstadoJugador.EN_JUEGO ? Colores.GREEN.getColor() : (estado == EstadoJugador.ENCARCELADO ? Colores.YELLOW.getColor() : Colores.RED.getColor());
    }
}