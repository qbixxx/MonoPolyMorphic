package org.example.model.use_case;

import org.example.model.jugador.Jugador;
import org.example.model.propiedades.Propiedad;

public class VenderPropiedadUseCase extends OpcionableLibre {

    private Propiedad propiedad;
    public VenderPropiedadUseCase(Jugador jugador, Propiedad propiedad) {
        super(jugador);
        this.propiedad = propiedad;
    }


    @Override
    public void ejecutar() {
        this.jugador.venderPropiedad(this.propiedad);
    }
}
