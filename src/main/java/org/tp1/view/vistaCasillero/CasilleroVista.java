package org.tp1.view.vistaCasillero;

import org.tp1.model.Jugador;

import java.util.Scanner;

public abstract class CasilleroVista {
    public abstract void mostrarCasillero();

    public abstract void mostrarOpcionesCasillero(Jugador jugador);

    public void mostrarOpcionesGenericas(Jugador jugador) {
        if (!jugador.obtenerTiroDado()) {
            System.out.println("1 para avanzar");
        }
        if (jugador.getPropiedades() != null) {
            System.out.println("1 para hipotecar");
            System.out.println("2 para vender una prop");
        }
        // bla bla
    }
}
