package org.example.model.estado.jugador;

import org.example.model.jugador.Jugador;

public class Quebrado implements Estado{

    private Jugador contex;
    @Override
    public int ejecutar(int tirar) {
        contex.rematarPropiedades();
        return 0;
    }
}
