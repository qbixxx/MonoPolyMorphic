package org.tp1.view.vistaCasillero;
import org.tp1.model.Jugador;
import org.tp1.model.juego.estadoJugador.EstadoJugador;

import java.util.Scanner;

public abstract class CasilleroVista {
    public abstract void mostrarCasillero();

    public abstract void mostrarOpcionesCasillero(Jugador jugador);

    public void mostrarOpcionesGenericas(Jugador jugador) {
        if (!jugador.siTiroDado() && !jugador.getEstadoJugador().equals(EstadoJugador.ENCARCELADO)) {
            System.out.println("1. Para avanzar");
        }
        System.out.println("2. Para pasar al siguiente");
        if (jugador.getPropiedades() != null) {
            System.out.println("3. Para hipotecar");
            System.out.println("4. Para deshipotecar");
            System.out.println("5. Para vender una prop");
            /*if ( si tiene un grupo completo) {
                // comprar casa / hotel
            }*/
        }

    }
}
