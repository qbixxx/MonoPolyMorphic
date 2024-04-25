package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroTransporte;
import org.tp1.view.Colores;

public class CasilleroTransporteVista extends CasilleroVista {

    private CasilleroTransporte casillero;

    public CasilleroTransporteVista(CasilleroTransporte casillero) {
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
        if (casillero.getDueno() != null){
            System.out.println(Colores.BLUE.getColor() +"Dueño:"+ casillero.getDueno().getNombre() + Colores.RESET.getColor());
        }else{
            System.out.println(Colores.BLUE.getColor() +"- No tiene Dueño" + Colores.RESET.getColor());
        }
        System.out.println(Colores.BLUE.getColor() + "--------------------" + Colores.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        if (jugador.getDineroDisponible() < casillero.getCostoCompra() || casillero.getDueno() != null) {
            System.out.println("No puedes comprar este transporte, presiona 3 para continuar");
        } else if (jugador.getDineroDisponible() >= casillero.getCostoCompra() && casillero.getDueno() == null) {
            System.out.println(Colores.GREEN.getColor()+" + Opciones en casillero de transporte" );
            System.out.println("1. Comprar el transporte por $"+this.casillero.getCostoCompra());
            System.out.println("3. No comprar el transporte"+Colores.RESET.getColor());
        }
    }
}
