package org.example.model.use_case;

import org.example.model.Logger;
import org.example.model.casilla.Terreno;
import org.example.model.jugador.Jugador;
import org.example.model.propiedades.Propiedad;

public class DesHipotecarUseCase extends OpcionableLibre {

    private Propiedad propiedad;

    public DesHipotecarUseCase(Jugador jugador, Propiedad propiedad) {
        super(jugador);
        this.propiedad = propiedad;
    }


    @Override
    public void ejecutar() {
        Logger.getInstance().info("Se llamo deshipotecar");
        this.jugador.desHipotecar((Terreno) propiedad);
    }
}
