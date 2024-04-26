package org.tp1.view.vistaCasillero;

import org.tp1.model.juego.estadoJugador.EstadoJugador;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroCarcel;
import org.tp1.view.Color;

import java.util.List;

public class CasilleroCarcelVista extends CasilleroVista {

    private final CasilleroCarcel casillero;

    public CasilleroCarcelVista(CasilleroCarcel casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Color.BLUE.getColor() + "-------------------------" + Color.RESET.getColor());
        System.out.println(Color.YELLOW.getColor() + casillero.getNombre() + Color.RESET.getColor());
        System.out.println(Color.GREEN.getColor() + "\tSolo Visitas" + Color.RESET.getColor());
        if (casillero.getJugadores() != null) {
            listarJugadores(casillero.getJugadores());
        }
        System.out.println(Color.RED.getColor() + "\tEncarcelados" + Color.RESET.getColor());
        if (casillero.getEncarcelados() != null) {
            listarJugadores(casillero.getEncarcelados());
        }
        System.out.println(Color.BLUE.getColor() + "-------------------------" + Color.RESET.getColor());
    }

    private void listarJugadores(List<Jugador> jugadores){
        for (Jugador jugador : jugadores) {
            System.out.println(
                    Color.RED.getColor()
                            + "\t\t|"
                            + Color.RESET.getColor()
                            + Color.GREEN.getColor()
                            + "+ "
                            + jugador.obtenerColor().getColor()
                            + jugador.getNombre()
                            + Color.RESET.getColor()
                            + Color.RED.getColor()
                            + "\t|"
                            + Color.RESET.getColor()
            );
        }
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        System.out.println("Opciones carcel");
        if (jugador.getEstadoJugador().equals(EstadoJugador.ENCARCELADO)) {
            System.out.println("1 - Pagar Multa de $100");
            System.out.println("Presiona otra tecla si quieres pasar el turno en la carcel");
        } else {
            this.mostrarOpcionesGenericas(jugador, null);
        }
    }
}
