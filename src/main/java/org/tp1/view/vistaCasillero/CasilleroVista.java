package org.tp1.view.vistaCasillero;
import org.tp1.model.Jugador;
import org.tp1.model.juego.Tablero;
import org.tp1.model.juego.estadoJugador.EstadoJugador;

import java.util.Scanner;

public abstract class CasilleroVista {



    public abstract void mostrarCasillero();

    public abstract void mostrarOpcionesCasillero(Jugador jugador);

    public void mostrarOpcionesGenericas(Jugador jugador, Tablero tablero) {
        if (!jugador.siTiroDado() && !jugador.getEstadoJugador().equals(EstadoJugador.ENCARCELADO)) {
            System.out.println("1. Para avanzar");
        }
        System.out.println("2. Para pasar al siguiente");
        if (jugador.getPropiedades() != null && !jugador.getPropiedades().isEmpty()) {
            System.out.println("5. Para vender una prop");
            System.out.println("7. Para hipotecar");
            System.out.println("8. Para deshipotecar");
            if (tablero != null && !tablero.chequearSiJugadorTieneAlgunGrupo(jugador).isEmpty()) {
                System.out.println("9. Construir una casa/hotel");
            }
        }
        if (jugador.obtenerTransportes() != null && !jugador.obtenerTransportes().isEmpty()) {
            System.out.println("6. Vender un transporte");
        }

    }
}
