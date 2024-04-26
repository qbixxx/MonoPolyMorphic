package org.tp1.view.vistaCasillero;

import org.tp1.model.juego.estadoJugador.EstadoJugador;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroCarcel;
import org.tp1.view.Colores;

import java.util.List;

public class CasilleroCarcelVista extends CasilleroVista {

    CasilleroCarcel casillero;

    public CasilleroCarcelVista(CasilleroCarcel casillero) {
        this.casillero = casillero;
    }

    public void mostrarCasillero() {
        System.out.println(Colores.BLUE.getColor() + "-------------------------" + Colores.RESET.getColor());
        System.out.println(Colores.YELLOW.getColor() + casillero.getNombre() + Colores.RESET.getColor());
        System.out.println(Colores.GREEN.getColor() + "\tSolo Visitas" + Colores.RESET.getColor());
        if (casillero.getJugadores() != null) {
            listarJugadores(casillero.getJugadores());
        }
        System.out.println(Colores.RED.getColor() + "\tEncarcelados" + Colores.RESET.getColor());
        if (casillero.getEncarcelados() != null) {
            listarJugadores(casillero.getEncarcelados());
        }
        System.out.println(Colores.BLUE.getColor() + "-------------------------" + Colores.RESET.getColor());
    }

    private void listarJugadores(List<Jugador> jugadores){
        for (Jugador jugador : jugadores) {
            System.out.println(
                    Colores.RED.getColor()
                            + "\t\t|"
                            + Colores.RESET.getColor()
                            + Colores.GREEN.getColor()
                            + "+ "
                            + Colores.RESET.getColor()
                            + jugador.getNombre()
                            + Colores.RED.getColor()
                            + "\t|"
                            + Colores.RESET.getColor()
            );
        }
    }

    public void mostrarOpcionesCasillero(Jugador jugador) {
        System.out.println("Opciones carcel");
        if (jugador.getEstadoJugador().equals(EstadoJugador.ENCARCELADO)) {
            System.out.println("1 - Pagar Multa de $100");
            System.out.println("2 - Pasar turno en carcel");
        } else {
            this.mostrarOpcionesGenericas(jugador, null);
        }
        // moverse
    }
}
