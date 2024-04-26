package example.model.use_case;

import org.example.model.Logger;
import org.example.model.jugador.Jugador;
import org.example.model.propiedades.Propiedad;

public class HipotecarUseCase extends OpcionableLibre {

    private Propiedad propiedad;
    public HipotecarUseCase(Jugador jugador, Propiedad propiedad) {
        super(jugador);
        this.propiedad = propiedad;
    }


    @Override
    public void ejecutar() {
        Logger.getInstance().info("Hipotecar");
        this.jugador.hipotecarPropiedad(propiedad);
    }
}
