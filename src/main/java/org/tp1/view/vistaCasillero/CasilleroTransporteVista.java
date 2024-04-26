package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroTransporte;
import org.tp1.view.Color;

public class CasilleroTransporteVista extends CasilleroVista {

    private CasilleroTransporte casillero;

    public CasilleroTransporteVista(CasilleroTransporte casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
        System.out.println(Color.YELLOW.getColor() + casillero.getNombre() + Color.RESET.getColor());
        if (casillero.getJugadores() != null) {
            for (Jugador jugador : casillero.getJugadores()) {
                System.out.println(Color.RED.getColor() + "\t|" + Color.RESET.getColor() + Color.GREEN.getColor() + "+ " + Color.RESET.getColor() + Color.RED.getColor() + jugador.getNombre() + "\t|" + Color.RESET.getColor());
            }
        }
        if (casillero.getDueno() != null){
            System.out.println(Color.BLUE.getColor() +"Dueño:"+ casillero.getDueno().getNombre() + Color.RESET.getColor());
        }else{
            System.out.println(Color.BLUE.getColor() +"- No tiene Dueño" + Color.RESET.getColor());
        }
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        if (jugador.getDineroDisponible() < casillero.getCostoCompra() || casillero.getDueno() != null) {
            System.out.println("No puedes comprar este transporte, presiona 3 para continuar");
        } else if (jugador.getDineroDisponible() >= casillero.getCostoCompra() && casillero.getDueno() == null) {
            System.out.println(Color.GREEN.getColor()+" + Opciones en casillero de transporte" );
            System.out.println("1. Comprar el transporte por $"+this.casillero.getCostoCompra());
            System.out.println("3. No comprar el transporte"+ Color.RESET.getColor());
        }
    }
}
