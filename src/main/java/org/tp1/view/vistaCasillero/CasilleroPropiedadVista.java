package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.view.Colores;

public class CasilleroPropiedadVista extends CasilleroVista {

    private CasilleroPropiedad casillero;

    public CasilleroPropiedadVista(CasilleroPropiedad casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Colores.BLUE.getColor() + "--------------------" + Colores.RESET.getColor());
        System.out.println(Colores.YELLOW.getColor() + casillero.getNombre() + Colores.RESET.getColor());
        if (casillero.getJugadores() != null) {
            for (Jugador jugador : casillero.getJugadores()) {
                System.out.println(Colores.RED.getColor() + "\t|" + Colores.RESET.getColor() + Colores.GREEN.getColor() + "+ " + Colores.RESET.getColor() + Colores.RED.getColor() + jugador.getNombre() + "\t|" + Colores.RESET.getColor());
            }
        }
        if (casillero.obtenerEdificios() != null) {
            for (int i = 0; i < casillero.obtenerEdificios().size(); i++) {
                System.out.printf("Casa n" + i + casillero.obtenerEdificios().get(i).obtenerPeaje());
            }
        }

        if (casillero.getDueno() != null){
            System.out.println(Colores.BLUE.getColor() +"Dueño:"+ casillero.getDueno().getNombre() + Colores.RESET.getColor());
        }else{
            System.out.println(Colores.BLUE.getColor() +"- No tiene Dueño" + Colores.RESET.getColor());
        }
        System.out.println(Colores.BLUE.getColor() + "--------------------" + Colores.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        if (jugador.getDineroDisponible() < casillero.getCostoCompra() ) {
            System.out.println("No podes comprar la propiedad, presiona ENTER para continuar");
        } else if (jugador.getDineroDisponible() >= casillero.getCostoCompra() && casillero.getDueno() == null ||
                !casillero.getDueno().equals(jugador)){
            System.out.println(Colores.GREEN.getColor()+" + Opciones en casillero de propiedad" );
            System.out.println("1. Comprar la propiedad por $"+this.casillero.getCostoCompra());
            System.out.println("3. No Comprar la propiedad."+Colores.RESET.getColor());
        } else {
            System.out.println("1. Avanzar (la propiedad ya es tuya)");
        }
    }
}
