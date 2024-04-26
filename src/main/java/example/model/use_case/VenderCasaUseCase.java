package example.model.use_case;

import org.example.model.casilla.Terreno;
import org.example.model.jugador.Jugador;
import org.example.model.propiedades.Propiedad;

public class VenderCasaUseCase extends OpcionableLibre {

    private Propiedad propiedad;
    public VenderCasaUseCase(Jugador jugador, Propiedad propiedad) {
        super(jugador);
        this.propiedad = propiedad;
    }


    @Override
    public void ejecutar() {
        this.jugador.venderCasa((Terreno) this.propiedad);
    }
}