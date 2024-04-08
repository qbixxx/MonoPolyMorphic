package org.tp1.view;

import org.tp1.model.Casillero;
import org.tp1.model.Juego;
import org.tp1.model.Jugador;

import java.util.Arrays;

public class JuegoVista {

    private Juego juego;

    public JuegoVista(Juego juego) {
        this.juego = juego;
    }

    public void mostrarDatosJuego(){ // modularizar
        for (Casillero casillero: juego.getTablero().getTablero()) { // horrible
            System.out.println(casillero.getNombre());
            if(casillero.getJugadores() != null) {
                System.out.println(Arrays.toString(casillero.getJugadores()));
            }

        }
        for (Jugador jugador: juego.getJugadores()) {
            System.out.println(jugador.getNombre());
            System.out.println(jugador.getEstadoJugador());
            System.out.println(jugador.getDineroDisponible());
            if (jugador.getPropiedades() != null) {
                for (Casillero propiedad: jugador.getPropiedades()) {
                    System.out.println(propiedad);
                }
            }
        }
        Jugador jugadorEnTurno = juego.jugadorEnTurnoActual();
        System.out.println(jugadorEnTurno.getNombre() + ", " + jugadorEnTurno.getDineroDisponible());
    }

    public void mostrarOpciones(){
        System.out.println("Para avanzar presiona la tecla 1");
    }
}
