package org.example.model.estado.jugador;

import org.example.model.Logger;
import org.example.model.jugador.Jugador;
import org.example.model.use_case.OpcionableLibre;
import org.example.model.use_case.OpcionablePreso;

public class Preso implements Estado {

    private int turnosPreso = 3;
    private final Jugador context;

    private final double fianza = 1000;

    public Preso(Jugador jugador) {
        this.context = jugador;
    }
    @Override
    public int ejecutar(int tirar) {
        if (tirar > turnosPreso) {
            Logger.getInstance().info("Es libre");
            context.setEstado(new Libre(this.context));
            this.context.agregarOpcionable(new OpcionableLibre(this.context));
        } else {
            this.context.agregarOpcionable(new OpcionablePreso(this.context, this.fianza));
            Logger.getInstance().info("Esta preso y no avanza");
            this.turnosPreso--;
        }
        return 0;
    }
}
