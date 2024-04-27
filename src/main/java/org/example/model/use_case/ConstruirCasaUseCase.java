package org.example.model.use_case;

import org.example.model.casilla.Terreno;
import org.example.model.jugador.Jugador;
import org.example.model.propiedades.Propiedad;

public class ConstruirCasaUseCase extends OpcionableLibre {

    private Propiedad propiedad;
    public ConstruirCasaUseCase(Jugador jugador, Propiedad propiedad) {
        super(jugador);
        this.propiedad = propiedad;
    }

    @Override
    public void ejecutar() {
        this.jugador.construirCasaEn((Terreno) this.propiedad);
    }
}
