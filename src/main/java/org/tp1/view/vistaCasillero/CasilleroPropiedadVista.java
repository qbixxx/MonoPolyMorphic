package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.construibles.Edificio;
import org.tp1.model.construibles.Hotel;
import org.tp1.view.Color;

public class CasilleroPropiedadVista extends CasilleroVista {

    private CasilleroPropiedad casillero;

    public CasilleroPropiedadVista(CasilleroPropiedad casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
        System.out.println(Color.YELLOW.getColor() + casillero.getNombre() + Color.RESET.getColor());
        if (casillero.getJugadores() != null) {
            for (Jugador jugador : casillero.getJugadores()) {
                System.out.println(Color.RED.getColor() + "\t|" + Color.RESET.getColor() + Color.GREEN.getColor() + "+ " + Color.RESET.getColor() + jugador.obtenerColor().getColor() + jugador.getNombre() + "\t|" + Color.RESET.getColor());
            }
        }
        if (casillero.obtenerEdificios() != null) {
            for (Edificio edificio: casillero.obtenerEdificios()) {
                if (edificio.getClass().equals(Hotel.class)) {
                    System.out.println("Hotel");
                } else {
                    System.out.println("Casa");
                }
            }
        }

        if (casillero.getDueno() != null){
            System.out.println(Color.BLUE.getColor() +"Dueño:"+ casillero.getDueno().obtenerColor().getColor() + casillero.getDueno().getNombre() + Color.RESET.getColor());
        }else{
            System.out.println(Color.BLUE.getColor() +"- No tiene Dueño" + Color.RESET.getColor());
        }
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        if (casillero.getDueno() != null && !casillero.getDueno().equals(jugador)) {
            System.out.println("1. Avanzar");
        }
        else if (jugador.getDineroDisponible() < casillero.getCostoCompra() ) {
            System.out.println("No podes comprar la propiedad");
        }
        else if (jugador.getDineroDisponible() >= casillero.getCostoCompra() && casillero.getDueno() == null){
            System.out.println(Color.GREEN.getColor()+" + Opciones en casillero de propiedad" );
            System.out.println("1. Comprar la propiedad por $"+this.casillero.getCostoCompra());
            System.out.println("Sino queres comprar la propiedad presiona 3"+ Color.RESET.getColor());
        } else {
            System.out.println("1. Avanzar (la propiedad ya es tuya)");
        }
        System.out.println("2. Para pasar al siguiente turno");
    }
}
