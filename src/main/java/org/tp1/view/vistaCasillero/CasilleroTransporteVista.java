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
        System.out.println(Color.YELLOW.getColor() + casillero.obtenerNombre() + Color.RESET.getColor());
        if (casillero.obtenerJugadores() != null) {
            for (Jugador jugador : casillero.obtenerJugadores()) {
                System.out.println(Color.RED.getColor() + "\t|" + Color.RESET.getColor() + Color.GREEN.getColor() +
                        "+ " + Color.RESET.getColor() + jugador.obtenerColor().getColor() + jugador.obtenerNombre() + "\t|" + Color.RESET.getColor());
            }
        }
        if (casillero.obtenerDueno() != null){
            System.out.println(Color.BLUE.getColor() +"Dueño:"+ casillero.obtenerDueno().obtenerColor().getColor() + casillero.obtenerDueno().obtenerNombre() + Color.RESET.getColor());
        }else{
            System.out.println(Color.BLUE.getColor() +"- No tiene Dueño" + Color.RESET.getColor());
        }
        System.out.println(Color.BLUE.getColor() + "--------------------" + Color.RESET.getColor());
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        if (jugador.obtenerDineroDisponible() < casillero.obtenerCostoCompra() || casillero.obtenerDueno() != null) {
            System.out.println("No puedes comprar este transporte");
        } else if (jugador.obtenerDineroDisponible() >= casillero.obtenerCostoCompra() && casillero.obtenerDueno() == null) {
            System.out.println(Color.GREEN.getColor()+" + Opciones en casillero de transporte" );
            System.out.println("1. Comprar el transporte por $"+this.casillero.obtenerCostoCompra());
            System.out.println("Presiona cualquier tecla sino queres comprar el transporte"+ Color.RESET.getColor());
        }
        System.out.println("2. Para pasar al siguiente");
    }
}
