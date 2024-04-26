package org.example.model.estado.jugador;

import org.example.model.Logger;
import org.example.model.jugador.Jugador;

public class Libre implements Estado{

    private Jugador context;

    public Libre(Jugador jugador) {
        this.context = jugador;
    }
    @Override
    public int ejecutar(int tirar) {
        Logger.getInstance().info("Avanza: " + tirar + " casillas");
        return tirar;
    }
}
