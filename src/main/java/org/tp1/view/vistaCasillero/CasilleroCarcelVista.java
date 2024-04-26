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
        System.out.println(Color.YELLOW.getColor() + casillero.obtenerNombre() + Color.RESET.getColor());
        System.out.println(Color.GREEN.getColor() + "\tSolo Visitas" + Color.RESET.getColor());
        if (casillero.obtenerJugadores() != null) {
            listarJugadores(casillero.obtenerJugadores());
        }
        System.out.println(Color.RED.getColor() + "\tEncarcelados" + Color.RESET.getColor());
        if (casillero.obtenerEncarcelados() != null) {
            listarJugadores(casillero.obtenerEncarcelados());
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
                            + jugador.obtenerNombre()
                            + Color.RESET.getColor()
                            + Color.RED.getColor()
                            + "\t|"
                            + Color.RESET.getColor()
            );
        }
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        System.out.println("Opciones carcel");
        if (jugador.obtenerEstadoJugador().equals(EstadoJugador.ENCARCELADO)) {
            System.out.println("1 - Pagar Multa de $100");
            System.out.println("Presiona otra tecla si quieres pasar el turno en la carcel");
        } else {
            this.mostrarOpcionesGenericas(jugador, null);
        }
    }
}
